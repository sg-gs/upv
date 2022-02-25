const zmq = require('zeromq')

const sc = zmq.socket('router'); // frontend
const sw = zmq.socket('router'); // backend

sc.bind('tcp://*:10000');
sw.bind('tcp://*:10001');

const workers = [];

sc.on('message', (c, sep, m) => {
  console.log(c);
  console.log(m);
  // console.log(msg);
  console.log('BROKER2/FRONTEND: MENSAJE DE BROKER1 (CLIENTE %s): %s', c, m);
  sw.send([workers.shift(), '', c, '', m]);
});

sw.on('message', (w, sep, c, sep2, r) => {
  if (c.toString() == '') { 
    console.log('BROKER2/BACKEND: MENSAJE DE WORKER %s: %s', w, r);
    workers.push(w); 
    // Necesitas añadir como primer parámetro el ID(w)
    // del socket a quién le quieres enviar el mensaje
    sw.send([w, '', 'CONFIRM-JOIN'])
    return;
  } else {
    sc.send([c, '', r]);
  }
})