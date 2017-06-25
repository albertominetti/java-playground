import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

class Changes {
  private static final Logger logger = LoggerFactory.getLogger(Changes.class);

  public Collection<String> verifyChanges(Object a, Object b) throws IllegalAccessException, InvocationTargetException {
    Collection<String> changes = new HashSet<>();
    Class<?> aClass = a.getClass();

    for (Method m : aClass.getMethods()) {

      Verify annotation = m.getAnnotation(Verify.class);
      VerifyInside annotationInside = m.getAnnotation(VerifyInside.class);
      if (annotation == null && annotationInside == null) {
        continue;
      }

      if (m.getParameterCount() > 0) {
        logger.error("Method has many parameters " + m.getName());
        continue;
      }

      Object ma = m.invoke(a);
      Object mb = m.invoke(b);

      if (annotationInside != null) {
        logger.debug("Verify inside method " + m.getName());
        if (ma != null && mb != null) {
          changes.addAll(this.verifyChanges(ma, mb));
        }
      }


      if (annotation != null) {


        logger.debug("Checking field " + m.getName());
        if (!Objects.equals(ma, mb)) {
          String tag = annotation.value().equals("") ? m.getName() : annotation.value();
          changes.add(tag);
        }
      } else {
        logger.debug("Skip method " + m.getName());
      }


    }
    return changes;

  }


  @Inherited // TODO check
  @Retention(RetentionPolicy.RUNTIME) // TODO check
  @Target({ElementType.METHOD})
  public @interface Verify {
    String value() default "";
  }


  @Inherited // TODO check
  @Retention(RetentionPolicy.RUNTIME) // TODO check
  @Target({ElementType.METHOD})
  public @interface VerifyInside {
  }

}
