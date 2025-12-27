Proyecto Compilador (simplificado) - U1

Contenido:
- `compilador.g` : gramática ANTLR v3 (classic) para un lenguaje Java-like simplificado.
- `CompiladorIDE.java` : IDE Swing con editor, toolbar, botones Open/Compile/Clear.
- `SemanticAnalyzer3.java` : analizador semántico compatible con ANTLR3 que implementa tablas de símbolos `SymT` y `SymTG` y revisa errores semánticos.
- `SymT.java`, `SymTG.java` : tablas de símbolos local y global.

Pasos para generar y ejecutar (Windows):


1) Descargar la runtime/classic ANTLR (ANTLR 3) jar, por ejemplo `antlr-3.5.2-complete.jar`, y ponerlo en el directorio del proyecto o en `C:\tools`.

2) Generar el lexer/parser (desde la carpeta `pROYECTO u1`):

```bash
java -jar path\to\antlr-3.5.2-complete.jar Compilador.g
```

Esto generará `CompiladorLexer.java`, `CompiladorParser.java`, y ficheros relacionados basados en la gramática ANTLR v3.

3) Compilar todo (añade el jar de runtime en el classpath):

```bash
javac -cp .;path\to\antlr-3.5.2-complete.jar *.java
```

4) Ejecutar el IDE:

```bash
java -cp .;path\to\antlr-3.5.2-complete.jar CompiladorIDE
```

Uso: abrir o pegar código en la caja de texto, pulsar `Compile`. Los errores semánticos aparecerán en la ventana de salida.
