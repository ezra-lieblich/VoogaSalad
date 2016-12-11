package engine.effect;

public class EffectManagerFactory {
    public static final String DEFAULT_PACKAGE_PATH = "engine.effect";
    AnnotatedDataMapFactory annotatedDataMapFactory;
    AnnotatedMethodMapFactory methodMapFactory;
    
    public EffectManagerFactory() {
        annotatedDataMapFactory = new AnnotatedDataMapFactory();
        methodMapFactory = new AnnotatedMethodMapFactory();
    }
    
    public EffectManager create() {
        return create(DEFAULT_PACKAGE_PATH);
    }
    
    public EffectManager create(String packagePath) {
        return new EffectTypeManager(methodMapFactory.create(packagePath), annotatedDataMapFactory.create(packagePath));
    }
    
}
