# JsWebView
Android基于JsBridge封装的高效带加载进度的WebView
可用作简单应用内置浏览器，帮你快速开发Hybrid APP



![](https://github.com/NeglectedByBoss/JsWebView/blob/master/TcBrowse/app/src/main/res/drawable/logoMax.png)

主要功能：

- 支持header
- 支持进度
- 支持自定义错误页面
- 支持h5和native的快速交互，简单易学
- 支持cookie同步
- 


#Dependencies

**Gradle:**  

root：

      repositories {
    maven { url "https://jitpack.io" }
    jcenter()
      }

Module:

       dependencies {
       .....
       compile 'com.tamic:browse:1.0.0'
    
       }

# Function
  
  **初始化**
      
        ProgressBarWebView  mProgressBarWebView = (ProgressBarWebView) findViewById(R.id.login_progress_webview);
      
  **设置WebViewClient**
  
  
  
           
          mProgressBarWebView.setWebViewClient(new CustomWebViewClient(mProgressBarWebView.getWebView()) {
            @Override
            public String onPageError(String url) {
                //指定网络加载失败时的错误页面
                return "file:///android_asset/error.html";
            }

            @Override
            public Map<String, String> onPageHeaders(String url) {

                // 可以加入header

                return null;
            }

            
        });

        // 打开页面，也可以支持网络url
        mProgressBarWebView.loadUrl("file:///android_asset/demo.html");
        
        
        

**回调js的方法**

        // 添加hander方法名 
        mHandlers.add("login");
       // 订阅此方法key
        mProgressBarWebView.registerHandlers(mHandlers, new JsHandler() {
            @Override
            public void OnHandler(String handlerName, String responseData, CallBackFunction function) {

                    String resquestData = "this native data"
                    
                     // 返回数据给js
                    function.onCallBack(resquestData);
               
            }
        });
**调用js**

        mProgressBarWebView.callHandler("callNative", "hello H5, 我是java", new JavaCallHandler() {
            @Override
            public void OnHandler(String handlerName, String jsResponseData) {
                Toast.makeText(MainActivity.this, "h5返回的数据：" + jsResponseData, Toast.LENGTH_SHORT).show();
            }
        });
        
        
**发送消息给js**


        mProgressBarWebView.send("hello world!", new CallBackFunction() {
            @Override
            public void onCallBack(String data) {
            
            // data 为js回传数据

                Toast.makeText(MainActivity.this, data, Toast.LENGTH_SHORT).show();

            }
        });


----------------------------



作者:Tamic & Yezhengnan.
介绍:http://www.jianshu.com/p/17054c21dd78
