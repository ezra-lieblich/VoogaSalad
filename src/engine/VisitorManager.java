package engine;

public interface VisitorManager {
    <U> void visitManager(VisitableManager<U> visitableManager, MethodData<Integer> dataMethod);
}
