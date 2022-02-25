const zmq = require('zeromq');
let req = zmq.socket('req');

req.identity = 'Worker1' + process.pid
req.connect('tcp://localhost:10001')

req.on('message', (typeOrClient, sep, msg) => {
  if (typeOrClient.toString() === 'CONFIRM-JOIN') {
    console.log('%s: JOINED', req.identity);
  } else {
    req.send([typeOrClient, '', msg + 'resppp']);
  }
});

req.send(['', '', 'JOIN']);