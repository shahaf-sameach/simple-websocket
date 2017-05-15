const WebSocket = require('ws');

const ws = new WebSocket('ws://localhost:8080/ServerEndpoint');

ws.on('open', function open() {
  // ws.send('something');
  ws.send(JSON.stringify({'msg' : 'hello', 'id' : 2}));
  // ws.close();
});

ws.on('message', function incoming(data, flags) {
  console.log(data);
  setTimeout(function() {
    ws.send(JSON.stringify({'msg' : 'fuck you', 'id' : Math.floor(Math.random() * (100 - 0)) + 0}));
}, 500);
});

