package engine;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;
import engine.observer.AbstractObservable;


public abstract class AbstractTypeManager<E extends Type> extends AbstractObservable<MethodData<?>> implements Manager<E> {
    //ManagerMediator managerMediator;
    Map<Integer, E> data;
    int activeId;
    
    @Override
    public int addEntry (E entry) {
        data.put(entry.getId(), entry);
        return entry.getId();
    }

    @Override
    public void removeEntry (int id) {
        data.remove(id);
        notifyObservers(new MethodObjectData<Integer>("RemoveEntry", id));
    }
        
//    protected <U> U getFromEntity(Supplier<U> getter) {
//        return getter.get();
//    }
//
//    protected <U> void setForEntity(Consumer<U> setter, U newValue) {
//        setter.accept(newValue);
//        //notifyObservers(activeId);
//    }
    
    @Override
    public void applyToAllEntities(Consumer<E> entry) {
        data.values().stream().forEach(entry);
    }
    
    /*public <U> Consumer<U> setForActiveEntity(Consumer<U> setter, U newValue) {
        //Apply Type::setName to activeEntity
        Consumer<U> blahtest = e - setter.accept(newValue);; //.setName(c); // Type::setName;
        List<E> tester = new ArrayList<E>();
        tester.forEach(setter);
        Consumer<U> activeFunc = c -> getActiveEntity()::setter;
        Consumer<AbstractTypeManager> eblah = c -> c.setForActiveEntity(getActiveEntity()::setter)
    }*/
    
//    @Override //TODO - hide in interface
    private E getEntity (int index) {
        return data.get(index);
    }

    //TODO - Make this private and just pass in a functional static interface
    @Override
    public E getActiveEntity () {
        return getEntity(activeId);
    }
    
    @Override
    public int getActiveId () {
        return activeId;
    }

    @Override
    public void setActiveId (int activeId) {
        this.activeId = activeId;
    }

    
    /*
     * public void activate(int ... ids) {
     * activeEntities.clear();
     * Arrays.asList(ids).stream().map(data::get).forEach(activeEntities::add);
     * }
     * 
     * protected void applyToActive(Consumer<E> function) {
     * activeEntities.stream().forEach(function);
     * }
     */
//    Method downPolymorphic = object.getClass().getMethod("visit",
//                                                         new Class[] { object.getClass() });
//
//                                                 if (downPolymorphic == null) {
//                                                         defaultVisit(object);
//                                                 } else {
//                                                         downPolymorphic.invoke(this, new Object[] {object});
//                                                 }
    //TODO - error might occur due to taking in a VisitableManager
    @Override
    public <U extends VisitableManager<MethodData<?>>> void visitManager(U visitableManager, MethodData<?> dataMethod) {
        try {
            Method visitMethod = this.getClass().getMethod("visit" + dataMethod.getMethod(), new Class[] {visitableManager.getClass()});
            visitMethod.invoke(this, new Object[] {visitableManager, dataMethod.getValue()});
        }
        catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    @Override
    public <U extends VisitorManager<MethodData<?>>> void accept (U visitor, MethodData<?> methodData) {
        visitor.visitManager(this, methodData);
    }
    
}
