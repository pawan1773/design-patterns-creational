public class Singleton {
    public static void main(String args[]) {
        final SingletonEnum ref1 = SingletonEnum.INSTANCE;
        final SingletonEnum ref2 = SingletonEnum.INSTANCE;
        
        System.out.println("SingletonEnum => " + (ref1 == ref2));
        
        final EagerSingleton ref3 = EagerSingleton.getInstance();
        final EagerSingleton ref4 = EagerSingleton.getInstance();
        
        System.out.println("EagerSingleton => " + (ref3 == ref4));
        
        final EagerStaticSingleton ref5 = EagerStaticSingleton.getInstance();
        final EagerStaticSingleton ref6 = EagerStaticSingleton.getInstance();
        
        System.out.println("EagerStaticSingleton => " + (ref5 == ref6));
        
        final LazySingleton ref7 = LazySingleton.getInstance();
        final LazySingleton ref8 = LazySingleton.getInstance();
        
        System.out.println("LazySingleton => " + (ref7 == ref8));
        
        final LazyThreadSafeSingleton ref9 = LazyThreadSafeSingleton.getInstance();
        final LazyThreadSafeSingleton ref0 = LazyThreadSafeSingleton.getInstance();
        
        System.out.println("LazyThreadSafeSingleton => " + (ref9 == ref0));
        
        final BillPughSingleton ref10 = BillPughSingleton.getInstance();
        final BillPughSingleton ref11 = BillPughSingleton.getInstance();
        
        System.out.println("BillPughSingleton => " + (ref10 == ref11));        
    }
}

class BillPughSingleton {
    
    static class BillPughSingletonHelper {
        private static BillPughSingleton INSTANCE = new BillPughSingleton();
    }
    
    private BillPughSingleton() {
        
    }
    
    public static BillPughSingleton getInstance() {
        return BillPughSingletonHelper.INSTANCE;
    }
}

class LazyThreadSafeSingleton {
    private static LazyThreadSafeSingleton INSTANCE;
    
    private LazyThreadSafeSingleton() {
        
    }
    
    public static LazyThreadSafeSingleton getInstance() {
        if(null == INSTANCE) {
            synchronized(LazyThreadSafeSingleton.class) {
                if(null == INSTANCE) {
                    INSTANCE = new LazyThreadSafeSingleton();
                }
            }
        }
        return INSTANCE;
    }
}

class LazySingleton {
    private static LazySingleton INSTANCE;
    
    private LazySingleton() {
        
    }
    
    public static LazySingleton getInstance() {
        if(null == INSTANCE) {
            INSTANCE = new LazySingleton();
        }
        return INSTANCE;
    }
}

class EagerStaticSingleton {
    private final static EagerStaticSingleton INSTANCE;
    
    static {
        INSTANCE = new EagerStaticSingleton();
    }
    
    private EagerStaticSingleton() {
        
    }
    
    public static EagerStaticSingleton getInstance() {
        return INSTANCE;
    }
}

class EagerSingleton {
    private final static EagerSingleton INSTANCE = new EagerSingleton();
    
    private EagerSingleton() {
        
    }
    
    public static EagerSingleton getInstance() {
        return INSTANCE;
    }
}

enum SingletonEnum {
    INSTANCE;
}
