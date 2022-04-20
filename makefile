compilar:limpiar
	mkdir bin
	find src -name "*.java" | xargs javac -cp bin -d bin
limpiar:
	rm -rf bin
jar:compilar
	jar cvfm tienda.jar Manifest.txt -C bin .
ejecutar:compilar
	java -cp bin aplicacion.Principal
javadoc:
	rm -rf html
	mkdir html
	find . -type f -name "*.java" | xargs javadoc -d html -encoding utf-8 -docencoding utf-8 -charset utf-8