grammar Sql;

main: select | delete | update;
select: 'select ' attributes ' from ' relation ' where ' condition ';' | 'select ' attributes ' from ' relation ';';
delete: 'delete from ' relation ' where ' condition ';' | 'delete from ' relation ';';
update: 'update ' relation ' set ' set ';';

attributes: attributes','attributes | attribute | function;
relation: ANY+;
condition: ANY+;
set: set','set | attribute '=' value;

attribute: ANY+;
value: ANY+;
function: functionname '(' attributes ')';

functionname: ANY+;

ANY: [a-zA-Z ];


