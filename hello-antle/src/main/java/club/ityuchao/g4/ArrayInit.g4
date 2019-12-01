grammar ArrayInit;
init:'{'value(','value)*'}';
value:init
     |Int
     ;
Int:[0-9]+;
WS:[ \t\r\n] -> skip;