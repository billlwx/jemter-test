import com.alibaba.fastjson.*; 
String response=prev.getResponseDataAsString();
        JSONObject responseObj=JSON.parseObject(response);
        String id=responseObj.getString("code")+"\r\n";
        String msg=responseObj.getString("msg")+"\r\n";

private String filePath="/Users/billli/exportFile.xls";
        BufferedOutputStream bos=null;
        FileOutputStream fos=null;
        File file=null;
        try{
        File file=new File(filePath);
        fos=new FileOutputStream(file,true); //添加参数true，以追加的方式添加内容
        bos=new BufferedOutputStream(fos);
        bos.write(msg.getBytes());
        }
        catch(Throwable ex){
        log.error("Error in Beanshell",ex);
        throw ex;
        }
        finally{
        if(bos!=null){
        try{
        bos.close();
        }catch(IOException e1){
        e1.printStackTrace();
        }
        }
        if(fos!=null){
        try{
        fos.close();
        }catch(IOException e1){
        e1.printStackTrace();
        }
        }
        }