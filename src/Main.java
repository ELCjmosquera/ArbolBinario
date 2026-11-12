public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Creamos los objetos Persona
        Persona p1 = new Persona("1001", "Carlos", 55);
        Persona p2 = new Persona("1002", "Laura", 32);
        Persona p3 = new Persona("1003", "Andrés", 29);
        Persona p4 = new Persona("1004", "Sofía", 10);
        Persona p5 = new Persona("1005", "Mateo", 8);
        Persona p6 = new Persona("1006", "Valentina", 3);

        // Insertamos en el árbol binario
        DoubleNode root = tree.addRoot(p1);
        DoubleNode nodoLaura = tree.insertLeft(root, p2);
        DoubleNode nodoAndres = tree.insertRight(root, p3);
        DoubleNode nodoSofia = tree.insertLeft(nodoLaura, p4);
        DoubleNode nodoMateo = tree.insertRight(nodoLaura, p5);
        DoubleNode nodoValentina = tree.insertLeft(nodoMateo, p6);

        System.out.println("Tamaño del árbol: " + tree.size()); // Tamaño del árbol: 6
        System.out.println("¿Está vacío?: " + tree.isEmpty()); // ¿Está vacío?: false
        System.out.println("Raíz: " + root.getData()); // Raíz: Persona{id='1001', nombre='Carlos', edad=55}
        System.out.println("Hijo izquierdo de Carlos: " + tree.left(root).getData()); // Hijo izquierdo de Carlos: Persona{id='1002', nombre='Laura', edad=32}
        System.out.println("Hijo derecho de Carlos: " + tree.right(root).getData()); // Hijo derecho de Carlos: Persona{id='1003', nombre='Andrés', edad=29}
        System.out.println("Padre de Sofía: " + tree.parent(nodoSofia).getData()); // Padre de Sofía: Persona{id='1002', nombre='Laura', edad=32}

        // Consultas estructurales
        System.out.println("¿Laura es nodo interno?: " + tree.isInternal(nodoLaura)); // ¿Laura es nodo interno?: true
        System.out.println("¿Andrés es nodo interno (hoja)?: " + tree.isInternal(nodoAndres)); // ¿Andrés es nodo interno (hoja)?: false
        System.out.println("Profundidad de Valentina: " + tree.depth(nodoValentina)); // Profundidad de Valentina: 3
        System.out.println("Altura de Laura: " + tree.height(nodoLaura)); // Altura de Laura: 2
        System.out.println("Altura total del árbol: " + tree.height(root)); // Altura total del árbol: 3

        // Prueba de eliminación (Mateo tiene un único hijo: Valentina)
        Object eliminado = tree.remove(nodoMateo);
        System.out.println("\nNodo eliminado: " + eliminado); // Nodo eliminado: Persona{id='1005', nombre='Mateo', edad=8}
        System.out.println("Nuevo hijo derecho de Laura: " + tree.right(nodoLaura).getData()); // Nuevo hijo derecho de Laura: Persona{id='1006', nombre='Valentina', edad=3}
        System.out.println("Nueva profundidad de Valentina: " + tree.depth(nodoValentina)); // Nueva profundidad de Valentina: 2
        System.out.println("Nuevo tamaño del árbol: " + tree.size()); // Nuevo tamaño del árbol: 5
    }
}