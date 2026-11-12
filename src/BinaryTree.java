public class BinaryTree {
    private DoubleNode root;
    private int size;

    public BinaryTree() {
        this.root = null;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isRoot(DoubleNode v) {
        return v != null && v == this.root;
    }

    public boolean isInternal(DoubleNode v) {
        return hasLeft(v) || hasRight(v);
    }

    public boolean hasLeft(DoubleNode v) {
        return v != null && v.getLeft() != null;
    }

    public boolean hasRight(DoubleNode v) {
        return v != null && v.getRight() != null;
    }

    public DoubleNode left(DoubleNode v) {
        if (v == null) return null;
        return v.getLeft();
    }

    public DoubleNode right(DoubleNode v) {
        if (v == null) return null;
        return v.getRight();
    }

    public DoubleNode parent(DoubleNode v) {
        if (v == null) return null;
        return v.getParent();
    }

    // Pseudocódigo diapositiva 36
    public int depth(DoubleNode v) {
        if (v == null) return -1;
        if (isRoot(v)) {
            return 0;
        } else {
            return 1 + depth(parent(v));
        }
    }

    // Pseudocódigo diapositiva 40 adaptado a árbol binario
    public int height(DoubleNode v) {
        if (v == null) return -1;
        if (!isInternal(v)) { // Caso base: es nodo externo (hoja)
            return 0;
        } else {
            int h = 0;
            if (hasLeft(v)) {
                h = Math.max(h, height(left(v)));
            }
            if (hasRight(v)) {
                h = Math.max(h, height(right(v)));
            }
            return 1 + h;
        }
    }

    public DoubleNode addRoot(Object e) {
        if (!isEmpty()) {
            throw new IllegalStateException("El árbol ya tiene una raíz.");
        }
        this.root = new DoubleNode(e);
        this.size = 1;
        return this.root;
    }

    public DoubleNode insertLeft(DoubleNode v, Object e) {
        if (v == null) throw new IllegalArgumentException("El nodo padre no puede ser nulo.");
        if (hasLeft(v)) {
            throw new IllegalStateException("El nodo ya tiene un hijo izquierdo.");
        }
        DoubleNode child = new DoubleNode(e);
        child.setParent(v);
        v.setLeft(child);
        this.size++;
        return child;
    }

    public DoubleNode insertRight(DoubleNode v, Object e) {
        if (v == null) throw new IllegalArgumentException("El nodo padre no puede ser nulo.");
        if (hasRight(v)) {
            throw new IllegalStateException("El nodo ya tiene un hijo derecho.");
        }
        DoubleNode child = new DoubleNode(e);
        child.setParent(v);
        v.setRight(child);
        this.size++;
        return child;
    }

    // Eliminación estándar en árbol binario enlazado (hasta 1 hijo)
    public Object remove(DoubleNode v) {
        if (v == null) throw new IllegalArgumentException("Nodo nulo.");
        if (hasLeft(v) && hasRight(v)) {
            throw new IllegalStateException("No se puede eliminar un nodo con dos hijos.");
        }

        DoubleNode child = hasLeft(v) ? left(v) : right(v);
        if (child != null) {
            child.setParent(parent(v));
        }

        if (isRoot(v)) {
            this.root = child;
        } else {
            DoubleNode parent = parent(v);
            if (v == left(parent)) {
                parent.setLeft(child);
            } else {
                parent.setRight(child);
            }
        }

        this.size--;
        Object temp = v.getData();
        // Limpiar referencias para ayudar al Garbage Collector
        v.setData(null);
        v.setLeft(null);
        v.setRight(null);
        v.setParent(null);
        return temp;
    }
}