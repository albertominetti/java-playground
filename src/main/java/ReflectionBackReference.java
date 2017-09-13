import org.apache.commons.lang3.builder.ToStringBuilder;

public class ReflectionBackReference
{
  public static void main(String[] args)
  {
    A a = new A();
    B b = new B();
    a.setB(b);
    b.setA(a);

    System.out.println(a.toString());
  }

  private static class A
  {
    private B b;

    public void setB(B b)
    {
      this.b = b;
    }

    public B getB()
    {
      return b;
    }

    @Override
    public String toString()
    {
      return ToStringBuilder.reflectionToString(this);
    }
  }

  private static class B
  {
    private A a;

    public void setA(A a)
    {
      this.a = a;
    }

    public A getA()
    {
      return a;
    }

    @Override
    public String toString()
    {
      return ToStringBuilder.reflectionToString(this);
    }
  }
}
