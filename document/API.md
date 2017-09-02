## 接口约定
### 一.上传
#### 1.1支持断点续传上传接口
> /file POST  

服务端保存
* 文件hash
* 缩略图URL thumb nail
* mime **注意用mime区分category_id & category_name**
* name
* size
* status 区分上传完毕/上传中/已删除
* upload_time

### 二.读取
#### 2.1 列表
> /file/list GET

##### 输入
    {
    	"category_id" : 1,	    //分类 tinyint
    	"page": 0,	            //页数 int
    	"size": 20,             //每页20个文件 int
    }
    
##### 输出
    {
    	"category_id" : 1,	//分类 tinyint
    	"page": 0,	//页数 int
    	"size": 20, //每页20个文件 int
    	"total": 1024,	//文件总量 int
    	"file_list": [{ //文件列表 list
    		"hash": "0b28d97a77822d27c2695caea196596c003e91fb",	//文件hash string
    		"thumbnail_url": "192.168.199.100/nail.jpg",	//预览图地址 string
    		"mime":	"image/jpeg",	//文件mime信息
    		"name": "【脸肿汉化组】[没後  (RYO)] RaspberryFlower (ロリータ)",	//文件名 string
    		"size": 10240.3,		//Kb记 float
    		"upload_time":1947483647 	//上传时间戳 int64
    	}]
    }

#### 2.2 文件详情
> /file/info GET

##### 输入
    {
    	"hash": "0b28d97a77822d27c2695caea196596c003e91fb"  //文件hash
    }
    
##### 输出
    {
        "status": 1     //区分上传完毕/上传中/已删除
        "hash": "0b28d97a77822d27c2695caea196596c003e91fb",	//文件hash string
        "thumbnail_url": "192.168.199.100/nail.jpg",	//预览图地址 string
        "mime":	"image/jpeg",	//文件mime信息
        "name": "【脸肿汉化组】[没後  (RYO)] RaspberryFlower (ロリータ)",	//文件名 string
        "size": 10240.3,		//Kb记 float
        "upload_time":1947483647 	//上传时间戳 int64
    }


#### 2.3 读取文件流
> /file/stream get

##### 输入
    {
    	"hash": "0b28d97a77822d27c2695caea196596c003e91fb"  //文件hash
    }
    //header
    {
        "Range" : "bytes=12517376" //从12517376比特推流
    }
    
    
##### 输出
    文件流

### 三.配置  
#### 3.1 远程连接
> /config/connection get

##### 输入 暂定
    {
    	"hash": "0b28d97a77822d27c2695caea196596c003e91fb"  //文件hash
    }
    
##### 输出
    {
        error_no: 0,
        error_msg: "",
        data: {
            token: "abc123",
            sign: "wertyuiop[!@#$%^&*()_"
        }
    }
