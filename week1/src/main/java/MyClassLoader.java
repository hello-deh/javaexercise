import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Base64;
import java.lang.reflect.Method;

public class MyClassLoader extends ClassLoader{

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String suffix = ".xlass";
        InputStream input = this.getClass().getResourceAsStream(name+suffix);
        Class<?> res = null;
        try {
            int len = input.available();
            byte[] bytes = new byte[len];
            input.read(bytes);
            decode(bytes);
            res = defineClass(name, bytes, 0, bytes.length);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    private void decode(byte[] bytes) {
        for (int i = 0; i < bytes.length; ++i) {
            bytes[i] = (byte) (255 - bytes[i]);
        }
    }

    public static void main(String[] args) {
        try {
            Class<?> cls = new MyClassLoader().findClass("Hello");
            Object obj = cls.newInstance();
            Method m = cls.getMethod("hello");
            m.invoke(obj);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }
}
