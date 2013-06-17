package com.seewhy.yfunctions.support;

/**
 * @author cbyamba
 *         Date: 2013-06-15
 *         Time: 20:44
 */
public class TupleNCodeGenerator {

    public static final String NL = "\n";
    public static final String TB = "\t";
    public static final String SP = " ";

    static enum Position {
        _0, _1, _2, _3, _4, _5, _6, _7, _8, _9;

        static enum PosSynonym1 {
            first(Position._0),
            second(Position._1),
            third(Position._2),
            fourth(Position._3),
            fifth(Position._4),
            sixth(Position._5),
            seventh(Position._6),
            eigth(Position._7),
            ninth(Position._8),
            tenth(Position._9);

            private Position pos;

            PosSynonym1(Position _pos) {
                pos = _pos;
            }

            public Position getPos() {
                return pos;
            }
        }
    }


    public static String TB(int length) {
        return token(TB, length);
    }

    public static String NL(int length) {
        return token(NL, length);
    }

    public static String token(String token, int length) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append(token);
        }
        return builder.toString();
    }

    public static String code() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            builder.append(code(i));
            builder.append(NL(2));
        }
        return builder.toString();
    }

    public static String code(int length) {
        StringBuilder builder = new StringBuilder();
        builder.append("public class Tuple").append(length).append(generics(length)).append(" {");
        builder.append(NL(2));
        builder.append(fields(length));
        builder.append(NL);
        builder.append(constructor(length));
        builder.append(NL(2));
        builder.append(getters(length));
        builder.append("}");
        return builder.toString();
    }

    static String generics(int length) {
        StringBuilder builder = new StringBuilder("<");
        builder.append("T0");
        for (int i = 1; i < length; i++) {
            builder.append(",").append("T").append(i);
        }
        builder.append(">");
        return builder.toString();
    }

    static String constructor(int length) {
        StringBuilder builder = new StringBuilder();
        builder.append(TB).append("public Tuple").append(length).append(constuctorArgs(length)).append(NL);
        //builder.append(TB(2)).append("for(int i=1; i<entries.length; i++) {");
        //builder.append(instanceofChecks(length)).append(NL);
        //builder.append(TB(2)).append("}").append(NL);
        //TODO above constructor
        builder.append(instantiation(length));
        builder.append(TB).append("}");
        //builder.append(TB).append("}");
        return builder.toString();
    }


    static String instantiation(int length) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append(TB(2)).append("this.").append("_").append(i).append(" = ").append("_").append(i).append(";").append(NL);
        }
        return builder.toString();
    }

    private static String constuctorArgs(int length) {
        StringBuilder builder = new StringBuilder("(");
        builder.append("T0").append(" _0");
        for (int i = 1; i < length; i++) {
            builder.append(",").append(SP).append("T").append(i).append(SP).append("_").append(i);
        }
        return builder.append(")").append(SP).append("{").toString();
    }

    private static String instanceofChecks(int length) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append(NL).append(TB(3)).append("if(entries[i] instanceof T").append(i).append(")").append(" {");
            builder.append(NL).append(TB(4)).append("_").append(i)
                    .append(SP).append("=").append(SP)
                    .append("(T").append(i).append(")").append("entries[i]").append(";");
            builder.append(NL).append(TB(3)).append("}");
        }
        return builder.toString();
    }

    static String fields(int length) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append(TB).append("private").append(SP).append("T").append(i).append(SP).append("_").append(i).append(";").append(NL);
            builder.append("");
        }
        return builder.toString();
    }

    static String getters(int length) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append(TB).append("public ").append("T").append(i).append(SP).append("_").append(i).append("()").append("{").append(NL);
            builder.append(TB(2)).append("return ").append("_").append(i).append(";").append(NL);
            builder.append(TB).append("}").append(NL);
        }
        return builder.toString();
    }

    public static void main(String... args) {
        print(code());
    }

    static void print(String text) {
        System.out.println(text);
    }
}
