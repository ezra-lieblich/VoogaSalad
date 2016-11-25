package engine;

public interface ManagerVisitor {
    <U extends Type> U visitManagerGetEntity(Manager<U> typeManager, int index);
}
