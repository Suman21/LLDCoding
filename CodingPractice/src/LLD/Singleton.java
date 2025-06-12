package LLD;

public class Singleton {
    private static Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if(instance == null)
        {
            synchronized (Singleton.class) // one thread at a time
            {
                if(instance == null)
                    instance = new Singleton();
            }
        }
        return instance;
    }
}
// Double check and best for performance and also thread safe
