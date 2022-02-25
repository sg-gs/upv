const zmq = require('zeromq');

const sc = zmq.socket('router'); // frontend
const sw = zmq.socket('router'); // backend
const req = zmq.socket('req');

sc.bind('tcp://*:9998');
sw.bind('tcp://*:9999');

req.connect('tcp://localhost:10000')

const pendingRequests = [];

sc.on('message', (c, sep, m) => {
  console.log('BROKER1/FRONTEND: MENSAJE DE CLIENTE %s: %s', c, m);
  pendingRequests.push({ c, m });
  sw.send([c, '', m.toString()]);
});

sw.on('message', (w, sep, c, sep2, r) => {
  console.log('BROKER1/BACKEND: RESPUESTA PARA CLIENTE %s DEL TRABAJADOR %s: %s', c, w, r);
  // any response from workers broker -> send to client
  sc.send([c, '', r]);
});
