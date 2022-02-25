const { socket } = require('zeromq');

const [_, __, frontEndPort, backendPort] = process.argv;

const cli = [];
const req = [];
const workers = [];

let tasksProcessed = 1;

const sc = socket('router')
  .bind('tcp://*:'+ frontEndPort)
  .on('message', (_, __, c, ___, m) => {
    console.log('message received from client %s: %s', c.toString(), m);
    if (workers.length == 0) {
      cli.push(c); 
      req.push(m);
    }
    
    sw.send([workers.shift(), '', c, '', tasksProcessed++]);
  });

const sw = socket('dealer')
  .bind('tcp://*:'+ backendPort)
  .on('message', (worker, sep, client, sep, response) => {
    console.log('worker %s answered: %s', w, c.toString());
    if (client == '' || client.length === 0) { 
      workers.push(w); 
      return; 
    }
    sc.send([c, '', r]);
  });