import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;
import java.lang.Comparable;

public class GCPC {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int n = io.getInt(); // number of teams
        int m = io.getInt(); // number of events
        Team[] teamsArr = new Team[n + 1]; // index 1 array of teams
        AVLTree avlTree = new AVLTree();
        for (int i = 1; i <= n; i++) {
            teamsArr[i] = new Team(i);
            avlTree.insert(teamsArr[i]);
        }
        for (int i = 0; i < m; i++) {
            int t = io.getInt(); // team number that solved the problem
            int p = io.getInt(); // penalty points for answering that question
            avlTree.delete(teamsArr[t]); // delete team from AVL tree
            teamsArr[t].solveProblem(p); // update team details
            avlTree.insert(teamsArr[t]); // insert team into AVL tree
            io.println(avlTree.teamRank(teamsArr[1], n));
        }
        io.close();
    }
}

class AVLTree {
    public Vertex root;

    public AVLTree() {
        root = null;
    }

    public Vertex search(Vertex T, Team v) {
        if (T == null) {
            return null; // not found
        }
        int comparator = v.compareTo(T.key);
        if (comparator > 0) {
            return search(T.right, v); // search to the right
        } else if (comparator < 0) {
            return search(T.left, v); // search to the left
        } else {
            return T; // found
        }
    }

    // public method called to find lowest ranked team in AVL
    public Team findMin(Vertex T) {
        if (T.left == null) {
            return T.key;
        } else {
            return findMin(T.left);
        }
    }

    // public method to find successor to given value v in AVL
    public Team successor(Team v) {
        Vertex vPos = search(root, v);
        if (vPos == null) {
            return null;
        } else {
            return successor(vPos);
        }
    }

    // helper recursive method to find successor to for a given vertex T in AVL
    public Team successor(Vertex T) {
        if (T.right != null) { // this subtree has right subtree
            return findMin(T.right); // the successor is the minimum of right subtree
        } else {
            Vertex par = T.parent;
            Vertex cur = T;
            // if par(ent) is not root and cur(rent) is its right children
            while ((par != null) && (cur.key.teamNumber == par.right.key.teamNumber)) {
                cur = par; // continue moving up
                par = cur.parent;
            }
            if (par == null) {
                return null;
            } else {
                return par.key;
            }
        }
    }

    // public method to delete a vertex containing key with Team v from AVL
    public void insert(Team v) {
        root = insert(root, v);
    }

    // overloaded recursive method to perform insertion of new vertex into BST
    protected Vertex insert(Vertex T, Team v) {
        if (T == null) {
            return new Vertex(v); // insertion point is found
        }

        int comparator = v.compareTo(T.key);
        if (comparator > 0) { // search to the right
            T.right = insert(T.right, v);
            T.right.parent = T;
        } else { // search to the left
            T.left = insert(T.left, v);
            T.left.parent = T;
        }
        if (T != null) {
            T.updateHeight();
            T.updateSize();
        }
        T = balance(T); 
        return T; // return the updated AVL
    }

    // public method to delete a vertex containing key with Team v from AVL
    public void delete(Team v) {
        root = delete(root, v);
    }

    // overloaded recursive method to perform deletion
    protected Vertex delete(Vertex T, Team v) {
        int comparator = v.compareTo(T.key);
        if (comparator < 0) {
            T.left = delete(T.left, v); // search to the left
        } else if (comparator > 0) {
            T.right = delete(T.right, v); // search to the right
        } else { // this is the node to be deleted, comparator == 0
            if (T.left == null && T.right == null) { // this is a leaf
                T = null; // simply erase this node
            } else if (T.left == null && T.right != null) { // only one child at right
                T.right.parent = T.parent;
                T = T.right; // bypass T
            } else if (T.left != null && T.right == null) { // only one child at left
                T.left.parent = T.parent;
                T = T.left; // bypass T
            } else { // has two children, find predecessor
                Team successorV = successor(v);
                T.key = successorV; // replace this key with the successor's key
                T.right = delete(T.right, successorV); // delete the old successorV
            }
        }
        if (T != null) {
            T.updateHeight();
            T.updateSize();
            T = balance(T);
        }
        return T; // return the updated AVL
    }

    public Vertex rightRotate(Vertex T) {
        if (T == null) {
            return null;
        }
        Vertex w = T.left;
        if (w == null) {
            return null;
        }
        w.parent = T.parent;
        if (T.parent == null) {
            root = w; // update root
        }
        T.parent = w;
        T.left = w.right;
        if (w.right != null) {
            w.right.parent = T;
        }
        w.right = T;

        T.updateHeight();
        T.updateSize();
        w.updateHeight();
        w.updateSize();

        return w;
    }

    public Vertex leftRotate(Vertex T) {
        if (T == null) {
            return null;
        }
        Vertex w = T.right;
        if (w == null) {
            return null;
        }
        w.parent = T.parent;
        if (T.parent == null) {
            root = w; // update root
        }
        T.parent = w;
        T.right = w.left;
        if (w.left != null) {
            w.left.parent = T;
        }
        w.left = T;

        T.updateHeight();
        T.updateSize();
        w.updateHeight();
        w.updateSize();

        return w;
    }

    public int balanceFactor(Vertex T) {
        if (T == null) {
            return 0;
        }
        int left = 0;
        int right = 0;
        if (T.left != null) { // has left child
            left = T.left.height;
        }
        if (T.right != null) { // has right child
            right = T.right.height;
        }
        return left - right;
    }

    public Vertex balance(Vertex T) {
        int bfT = balanceFactor(T);
        if (bfT == 2) { // left heavy
            if (balanceFactor(T.left) == -1) { // left right
                T.left = leftRotate(T.left);
            } // left left
            T = rightRotate(T);
        } else if (bfT == -2) { // right heavy
            if (balanceFactor(T.right) == 1) { // right left
                T.right = rightRotate(T.right);
            } // right right
            T = leftRotate(T);
        }
        return T;
    }

    public int teamRank(Team v, int n) {
        // rank(T,v) returns the number of teams lower ranked than current team + 1
        // n represents the number of teams
        // ranking of the team = number of teams - number of teams lower + 1
        return n - rank(this.root, v) + 1;
    }

    public int rank(Vertex T, Team v) { // assume v exists in the AVL and size attribute is there
        int comparator = v.compareTo(T.key);
        if (comparator < 0) {
            return rank(T.left, v); // v is on the left 
        } else if (comparator > 0) { // v is > node's left and plus this rank
            int leftSize = 0;
            if (T.left != null) {
                leftSize = T.left.size;
            }
            return leftSize + 1 + rank(T.right, v);
        } else { // equals
            int leftSize = 0;
            if (T.left != null) {
                leftSize = T.left.size;
            }
            return leftSize + 1;
        }
    }
}

class Vertex {
    Vertex left;
    Vertex right;
    Vertex parent;
    Team key;
    int height;
    int size;

    public Vertex(Team team) {
        left = null;
        right = null;
        parent = null;
        key = team;
        height = 0;
        size = 1;
    }

    public void updateHeight() {
        if (this.left == null && this.right == null) { // this is a leaf
            this.height = 1;
        } else if (this.left == null) { // no left child
            this.height = 1 + this.right.height;
        } else if (this.right == null) { // no right child
            this.height = 1 + this.left.height;
        } else { // has two child
            this.height = 1 + Math.max(this.left.height, this.right.height);
        }
    }

    public void updateSize() {
        if (this.left == null && this.right == null) { // this is a leaf
            this.size = 1;
        } else if (this.left == null) { // no left child
            this.size = 1 + this.right.size;
        } else if (this.right == null) { // no right child
            this.size = 1 + this.left.size;
        } else { // has two child
            this.size = 1 + this.left.size + this.right.size;
        }
    }
}

class Team implements Comparable<Team> {
    int teamNumber;
    int numSolvedProblems;
    int totalPenalty;

    public Team(int teamNumber) {
        this.teamNumber = teamNumber;
        this.numSolvedProblems = 0;
        this.totalPenalty = 0;
    }

    public void solveProblem(int penalty) {
        this.numSolvedProblems++;
        this.totalPenalty += penalty;
    }

    @Override
    public int compareTo(Team another) {
        // returns 1 if the team is higher ranked (1st)
        // returns 0 if the team is the same
        // returns -1 if the team is lower ranked (last)
        if (this.numSolvedProblems > another.numSolvedProblems) {
            return 1;
        } else if (this.numSolvedProblems < another.numSolvedProblems) {
            return -1;
        } else { // this.numSolvedProblems == another.numSolvedProblems
            if (this.totalPenalty < another.totalPenalty) {
                return 1;
            } else if (this.totalPenalty > another.totalPenalty) {
                return -1;
            } else { // same penalty points, smaller team number will be higher ranked
                return another.teamNumber - this.teamNumber;
            }
        }
    }
}

class Kattio extends PrintWriter {
    public Kattio(InputStream i) {
        super(new BufferedOutputStream(System.out));
        r = new BufferedReader(new InputStreamReader(i));
    }

    public Kattio(InputStream i, OutputStream o) {
        super(new BufferedOutputStream(o));
        r = new BufferedReader(new InputStreamReader(i));
    }

    public boolean hasMoreTokens() {
        return peekToken() != null;
    }

    public int getInt() {
        return Integer.parseInt(nextToken());
    }

    public double getDouble() {
        return Double.parseDouble(nextToken());
    }

    public long getLong() {
        return Long.parseLong(nextToken());
    }

    public String getWord() {
        return nextToken();
    }

    private BufferedReader r;
    private String line;
    private StringTokenizer st;
    private String token;

    private String peekToken() {
        if (token == null)
            try {
                while (st == null || !st.hasMoreTokens()) {
                    line = r.readLine();
                    if (line == null)
                        return null;
                    st = new StringTokenizer(line);
                }
                token = st.nextToken();
            } catch (IOException e) {
            }
        return token;
    }

    private String nextToken() {
        String ans = peekToken();
        token = null;
        return ans;
    }
}
