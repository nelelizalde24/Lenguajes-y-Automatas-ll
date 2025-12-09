class Test {
public int unused() {
return 42;
}

public int usedOnce() {
return 1;
}

public int usedMany() {
return 2;
}

public int caller() {
int a = usedOnce();
int b = usedMany();
int c = usedMany();
int d = 2 + 3 * 4; // reducible: 2 + (3*4) = 14
int e = 5 + 7; // reducible: 12
return a + b + c + d + e;
}

public int forwardCaller() {
int x = forwardCalled(); // llamada antes de la declaración
return x;
}

public int forwardCalled() {
return 10;
}
}