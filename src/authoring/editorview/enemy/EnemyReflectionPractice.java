package authoring.editorview.enemy;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import org.reflections.Reflections;
import authoring.editorview.enemy.subviews.editorfields.EnemyNameField;
import engine.effect.EffectData;


public class EnemyReflectionPractice {
    
    public static final Class<? extends Annotation> ANNOTATION_TYPE = EffectData.class;
    private EnemyNameField enemyName;
    private ResourceBundle labelsResource = ResourceBundle.getBundle("resources/GameAuthoringEnemy");

    public void testing () {
        enemyName = new EnemyNameField(labelsResource);
        Class myClass = enemyName.getClass();
        Method[] methods = myClass.getMethods();
        for (Method n: methods) {
            System.out.println(n);
        }
        
    }

    protected Collection<Field> applySearch (Reflections reflections) {
        return reflections.getFieldsAnnotatedWith(ANNOTATION_TYPE);
    }

}
