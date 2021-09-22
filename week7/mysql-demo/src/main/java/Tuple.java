public class Tuple {
    public static class TwoTuple<A, B> {

        public final A first;

        public final B second;

        public TwoTuple(A a, B b){
            first = a;
            second = b;
        }

        public String toString(){
            return "(" + first + ", " + second + ")";
        }

    }

    public static class ThreeTuple<A, B, C> extends TwoTuple<A, B>{

        public final C third;

        public ThreeTuple(A a, B b, C c) {
            super(a, b);
            third = c;
        }

        public String toString(){
            return "(" + first + "," + second + "," + third + ")";
        }

    }

    public static class FourTuple<A, B, C, D> extends ThreeTuple<A, B, C> {
        public final D fourth;

        public FourTuple(A a, B b, C c, D d) {
            super(a, b, c);
            fourth = d;
        }
        public String toString() {
            return "(" + first + "," + second + "," + third + "," + fourth + ")";
        }
    }
}

