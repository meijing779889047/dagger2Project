#### <center>Dagger2初识</center>

* 使用Dagger2的优势？
  
      避免重复的进行对象的初始化创建，使用一种更省力，更自动化的方式进行对象的创建，提高开发效率

* Dagger2是一种技术手段

* Dagger2采用ioc的设计模式，在编译的时候采用反射机制进行注入，但是为了提高性能，在运行的时候采用apt使用动态代码生成实现注入

* 控制反转（IOC）:是一种面向对象的编程法测，用于解决解耦问题，分为两种类型:依赖注入，依赖查找

* 依赖注入
     
      目标类中所依赖类的实例初始化的过程，不通过编码手动创建，而是通过技术的手段将目标类所依赖类的实例进行初始化并注入到目标类中。

* Dagger2分为三个模块

   * 依赖提供方 
       
         类似于工厂模式，提供所需要的依赖的对象的实例，在实际编程中是用@module注解标注的一个类，里面有用@provides注解标注的提供所需依赖对象实例的方法

  * 依赖需求方
  
         声明依赖的对象（属性），在实际编程中对应Activity/class/fragment,在里面声明的对象，就是需要依赖的对象、

   *  依赖注入组件（Component）

          用将依赖提供方提供的实例注入到依赖需求方中，在实际编码过程中对应用@Component注解标注的一个接口/抽象类，Dagger2会自动生成其对应的
   


 * Dagger2的工作流程
 
        1.依赖需要方将依赖需求方的对象传入到Component的实现类中
        
        2.Component实现类会根据传入的对象，会根据传入的对象找到相应的Activity/framgent/class,之后去查找是否用@inject注解标注的属性，这些属性就是所需要依赖的对象

        3.确定那些对象需要依赖后，Component会去与之关联的Module中查找是否有用@provides注解标注的方法,这些方法中是否有返回指定对象类型的实例，有的话调用此方法将初始化的的实例设置到需要方的实例


#### Dagger2的使用

* 在项目的根目录下的build.gradle添加Apt插件

        //添加apt插件
        classpath 'com.neenbedankt.gradle.plugins:android-apt:1.8'

* 在app下的build.gradle添加依赖

      //应用apt插件
      apply plugin: 'com.neenbedankt.android-apt'

	  dependencies {
	    //引入dagger2
	    compile 'com.google.dagger:dagger:2.5'
	    apt 'com.google.dagger:dagger-compiler:2.5'
	    //java注解
	    provided 'org.glassfish:javax.annotation:10.0-b28'
	
	}

#### Dagger2实现方式一: 通过在构造函数上添加@inject注解实现
   
  * inject
       
         用于标注目标类的依赖对象以及依赖的构造函数

  * 编写一个ImplementWayOneBean类,这个类就是需要方所需要依赖的实例的类，用@inject注解标注构造函数
     

		  public class ImplementWayOneBean {
		
		    private  String  name;
		
		    @Inject
		    public ImplementWayOneBean() {
		    }
		
		
		    public String getName() {
		        return name;
		    }
		
		    public void setName(String name) {
		        this.name = name;
		    }
		}
 
 

      
 *  编写一个Component接口，这个接口用@component注解标注表明是注入组件
 
			@Component
			public interface ImplementWayOneComponent {
			
			    void   inject(ImplementWayOneActivity  mImplementWayOneActivity);
			}


 *  在as上rebuild一下

 *  在Activity/fragment/class 上声明对象，用inject注解标注
  
     
		 public class ImplementWayOneActivity extends AppCompatActivity {
		
			     private TextView  tvData;
			
			     @Inject
			     ImplementWayOneBean bean;
			
			     
			    @Override
			    protected void onCreate(Bundle savedInstanceState) {
			        super.onCreate(savedInstanceState);
			        setContentView(R.layout.activity_implement_way_one);
			        tvData= (TextView) findViewById(R.id.tv_data);
			        DaggerImplementWayOneComponent.builder().build().inject(this);
			        bean.setName("张三");
			        tvData.setText("通过Dagger2的实现方式1采用@inject注解标注的构造函数获取的数据："+bean.getName());
			    }
			}



  说明：在as上rebuild后会在app下的build/gengerated/source/apt/debug目录下生成一系列的文件

 ![](http://img1.ph.126.net/D2Yts_lf2lbkZfNOekBgbw==/6632116699794387385.png)


  
	@Generated(
	  value = "dagger.internal.codegen.ComponentProcessor",
	  comments = "https://google.github.io/dagger"
	)
	public enum ImplementWayOneBean_Factory implements Factory<ImplementWayOneBean> {
	  INSTANCE;
	
	  @Override
	  public ImplementWayOneBean get() {
	    return new ImplementWayOneBean();
	  }
	
	  public static Factory<ImplementWayOneBean> create() {
	    return INSTANCE;
	  }
	}
   
   这个类是用于创建和获取用@inject注解标注的构造函数的实例和工厂



 
	@Generated(
	  value = "dagger.internal.codegen.ComponentProcessor",
	  comments = "https://google.github.io/dagger"
	)
	public final class ImplementWayOneBean_MembersInjector
	    implements MembersInjector<ImplementWayOneBean> {
	  private final Provider<String> nameProvider;
	
	  public ImplementWayOneBean_MembersInjector(Provider<String> nameProvider) {
	    assert nameProvider != null;
	    this.nameProvider = nameProvider;
	  }
	
	  public static MembersInjector<ImplementWayOneBean> create(Provider<String> nameProvider) {
	    return new ImplementWayOneBean_MembersInjector(nameProvider);
	  }
	
	  @Override
	  public void injectMembers(ImplementWayOneBean instance) {
	    if (instance == null) {
	      throw new NullPointerException("Cannot inject members into a null reference");
	    }
	    instance.name = nameProvider.get();
	  }
	
	  public static void injectName(ImplementWayOneBean instance, Provider<String> nameProvider) {
	    instance.name = nameProvider.get();
	  }
	}

   这个类使用与获取到ImplementWayOneBean_Factory的实例与DaggerImplementWayOneComponent的实例进行关联

		
		@Generated(
		  value = "dagger.internal.codegen.ComponentProcessor",
		  comments = "https://google.github.io/dagger"
		)
		public final class DaggerImplementWayOneComponent implements ImplementWayOneComponent {
		  private MembersInjector<ImplementWayOneActivity> implementWayOneActivityMembersInjector;
		
		  private DaggerImplementWayOneComponent(Builder builder) {
		    assert builder != null;
		    initialize(builder);
		  }
		
		  public static Builder builder() {
		    return new Builder();
		  }
		
		  public static ImplementWayOneComponent create() {
		    return builder().build();
		  }
		
		  @SuppressWarnings("unchecked")
		  private void initialize(final Builder builder) {
		
		    this.implementWayOneActivityMembersInjector =
		        ImplementWayOneActivity_MembersInjector.create(ImplementWayOneBean_Factory.create());
		  }
		
		  @Override
		  public void inject(ImplementWayOneActivity mImplementWayOneActivity) {
		    implementWayOneActivityMembersInjector.injectMembers(mImplementWayOneActivity);
		  }
		
		  public static final class Builder {
		    private Builder() {}
		
		    public ImplementWayOneComponent build() {
		      return new DaggerImplementWayOneComponent(this);
		    }
		  }
		}


  其中DaggerImplementWayOneComponent类是component接口类的的实现类，DaggerImplementWayOneComponent.builder().build()用于创建DaggerImplementWayOneComponent的对象， 然后将Activity/fragment/calss 的对象传入到ImplementWayOneBean_Factory中，让其进行注入

  

#### Dagger2实现方式二: 通过Module实现

* Module 
   
     该类用@Module注解标注，用于提供返回依赖对象实例的方法，相比于方法1,还可以管理第三方依赖库的对象的创建，以及对用不同方法获取同一对象进行处理

* 编写一个ImplementWayTwoBean类,这个类就是需要方所需要依赖的实例的类，无需用@inject进行注解标注
     

		  public class ImplementWayTwoBean {
		
		    private  String  name;
		
		    public ImplementWayTwoBean() {
		    }
		
		
		    public String getName() {
		        return name;
		    }
		
		    public void setName(String name) {
		        this.name = name;
		    }
		}
 
 

 * 编写一个ImplementWayTwoModule类，用module注解进行标注，内部提供返回所需依赖对象的方法，使用provides进行注解
 
		@Module
		public class ImplementWayTwoModule {
		
		    @Provides
		    @Named("way1")
		    public  ImplementWayTwoBean  getImplementWayTwoBean1(){
		         return  new  ImplementWayTwoBean();
		    }
		
		    @Provides
		    @Named("way2")
		    public  ImplementWayTwoBean  getImplementWayTwoBean2(){
		        return  new  ImplementWayTwoBean();
		    }
		}


* 编写一个ImplementWayTwoComponent类，用Component注解进行标注

   * 有两个属性  
   
	    modules       class数组  声明该Component需要那些Module  component会去关联的Module中查找需要依赖对象的方法（用Provides标注的）

	   dependencies  class数组  声明该Component的依赖关系


			@Component(modules = ImplementWayTwoModule.class)
			public interface ImplementWayTwoComponent {
			
			    void   inject(ImplementWayTwoActivity  mImplementWayTwoActivity);
			}


* 在as中rebuild一下项目

* 在Activity/fragment/class 中声明所需要依赖的属性

/**
 * Dagger2实现方式1  使用module实现
 */
public class ImplementWayTwoActivity extends AppCompatActivity {


	    private TextView tvData;
	
	    @Inject
	    @Named("way1")
	    ImplementWayTwoBean bean1;
	    @Inject
	    @Named("way2")
	    ImplementWayTwoBean bean2;
	
	
	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_implement_way_two);
	        tvData= (TextView) findViewById(R.id.tv_data);
	        DaggerImplementWayTwoComponent.builder().implementWayTwoModule(new ImplementWayTwoModule()).build().inject(this);
	        bean1.setName("张三");
	        bean2.setName("李四");
	        tvData.setText("通过Dagger2的实现方式1采用@inject注解标注的构造函数获取的数据："+bean1.getName()+"和"+bean2.getName());
	    }
	}


说明：这种实现方式的原理与与方式1是一样的；
     我们发现在module类中和Activity中都加入一个@named注解标注，这个是一个标识符，里面只能传字符串，当我们有几个不同的方式获取获取同一种实例，Dagger2如何去区别我们现在到底需要通过哪种方法获取实例了，通过@Named注解就可以区分；在Componet中声明module，表明该component需要哪些module，让其与之关联。






## Dagger2两种注入方式的优先级

  * 1.首先会从module中开始查找是否有创建所需实例的方法
  * 2.若查找到后，查看该方法是否需要参数
        
     * 若存在，根据步骤1开始初始化每个参数
     * 若不要存在，直接初始化实例，结束查找
  

  * 3.若没有查找到，将去该对象的的构造函数是否被用@inject注解标注，并查看是否需要参数
  
    * 若存在，根据步骤1开始初始化每个参数
     * 若不要存在，直接初始化实例，结束查找



从这里我们看出module的优先级要高于@inject标注的构造函数



##  Dagger2中的各种注解说明
  
#### Dagger2注解之Named/qualifier


* 使用需求：若在项目中对于同一种实例,可以用多种方式获取，那么我们在声明该对象的时候，若何让Dagger2根据自己的意愿去实例化这个对象了？
 
  解决方式：通过Named/qualifier对每一个方法进行区分标识，这样每一个方法都有一个标识符，我们在声明对象时采用对应的标识就可以，让你声明的对象在进行注入的时候调用指定的方法进行初始化


* Named和qualifier的区别

      Named和qualifier都有一个value值，但是Named的value只能是字符串；qualitfy可以通过自定义是value值是任意一种类型

* Named的使用   我们采用方式2的实现方式
   
 1.在Module类中由@provides声明的方法上加入@named注解
   
			@Module
			public class NamedModule {
			
			    @Provides
			    @Named("way3")
			    public NamedBean getNamedBean1(){
			         return  new NamedBean();
			    }
			
			    @Provides
			    @Named("way4")
			    public NamedBean getNamedBean2(){
			        return  new NamedBean();
			    }
			}

   
 
    
                       
          


   
  
   2.在声明的对象的时候，同样要用@named注解标注


	
		public class NamedActivity extends AppCompatActivity {
		
		    private TextView tvData;
		
		    @Inject
		    @Named("way3")
		    NamedBean bean1;
		    @Inject
		    @Named("way4")
		    NamedBean bean2;
		
		}





 
* Qualifier的使用  我们采用方式2的实现方式

 1.自定义QualifierType类，通过@qualifier注解标注

		@Qualifier
		@Documented
		@Retention(RetentionPolicy.RUNTIME)
		public @interface QualiferType {
		
		    int value()  default  1;//类型（可变）  方法   默认   1（可变）
		}



   2.在Module类中由@provides声明的方法上加入@QualiferType注解

		@Module
		public class QualifierModule {
		
		    @Provides
		    @QualiferType(1)
		    public QualifierBean getQualifierBean1(){
		         return  new QualifierBean();
		    }
		
		    @Provides
		    @QualiferType(2)
		    public QualifierBean getQualifierBean2(){
		        return  new QualifierBean();
		    }
		}
  
   3.在声明的对象的时候，同样要用@QualiferType注解标注

		
		public class QualifierActivity extends AppCompatActivity {
		    private TextView tvData;
		
		    @Inject
		    @QualiferType(1)
		    QualifierBean bean1;
		    @Inject
		    @QualiferType(2)
		    QualifierBean bean2;
		
		}




### Dagger2注解之singleton/scope

  * 使用需求：当我们使用不同的方法初始化同一个类型的对象后，我们会发觉创建的对象是不是同一个，我们是否可以让其对象只有一个了?即保持
  单例的模式

    解决方式：通过在提供依赖对象的方法上添加@singleton/@scope注解标注之后，他创建的实例将是单例的；但是若采用的是构造函数注入，这时scope/instance必须在类上标注，而不是在构造函数上标注（将会出现异常），

 * singleton与scope的区别
    
      singleton继承与scope；scope可以通过自定义实现区分，当是activity依赖我们可以通过perActivity进行标识，当是Fragment时可以通过perfragment进行标识，提高代码的可读性

* 说明：  
           
      单例是在同一个Component实例提供依赖的前提下才有效的,不同的Component实例只能通过Component依赖才能实现单例.也就是说,你虽然在两个Component接口上都添加了PerActivity注解,但是这两个Component提供依赖时是没有联系的,他们只能在各自的范围内实现单例
  
 * singleton的使用
 
  1.在Module类中由@provides声明的方法上加入@singleton注解

		@Module
		public class SingletonModule {
		
		    @Provides
		    @Named("way3")
		    @Singleton
		    public SingletonBean getSingletonBean1(){
		         return  new SingletonBean();
		    }
		
		    @Provides
		    @Named("way4")
		    @Singleton
		    public SingletonBean getSingletonBean2(){
		        return  new SingletonBean();
		    }
		
		
		}





2.在component接口类上标注@singleton注解

			@Singleton
			@Component(modules = SingletonModule.class)
			public interface SingletonComponent {
			
			    void   inject(SingletonActivity mNamedActivity);
			}


3.直接声明属性即可

		public class SingletonActivity extends AppCompatActivity {
		
		    private TextView tvData;
		
		    @Inject
		    @Named("way3")
		    SingletonBean bean1;
		
		    @Inject
		    @Named("way3")
		    SingletonBean bean2;
		
		
		}





* scope的使用
 
1.编写scope接口，使用@scope注解标注

		@Scope
		@Retention(RetentionPolicy.RUNTIME)
		public @interface ScopePerActivity {
		
		
		}


2.在module类中的提供所需依赖对象的方法
			
			@Module
			public class ScopeModule {
			
			    @ScopePerActivity
			    @ScopeType(1)
			    @Provides
			    public ScopeBean getScopeBean1(){
			         return  new ScopeBean();
			    }
			
			    @ScopePerActivity
			    @ScopeType(2)
			    @Provides
			    public ScopeBean getScopeBean2(){
			        return  new ScopeBean();
			    }
			}
			  


3.在component接口上使用@peractivity注解进行标注

			@ScopePerActivity
			@Component(modules = ScopeModule.class)
			public interface ScopeComponent {
			
			    void   inject(ScopeActivity mNamedActivity);
			}

4.直接声明属性即可

			public class ScopeActivity extends AppCompatActivity {
			    private TextView tvData;
			
			    @Inject
			    @ScopeType(1)
			    ScopeBean bean1;
			
			    @Inject
			    @ScopeType(1)
			    ScopeBean bean2;
			
			}




### Dagger2注解之dependience

* 使用需求：项目的工具类，我们想让这个工具类在整个app的生命周期都是单例的，常用的有sharedprefrence工具类，Activity的管理类
