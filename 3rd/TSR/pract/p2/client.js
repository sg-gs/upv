const { socket } = require('zeromq');

const [_, __, frontendUrl, identity, reqMessage] = process.argv;

console.log(frontendUrl, identity, reqMessage);

const req = socket('req')
  .connect(frontendUrl)
  .on('message', (msg)=> {
    console.log('resp: '+msg)
    process.exit(0);
  });

req.identity = identity;
req.send([identity, '', reqMessage]);