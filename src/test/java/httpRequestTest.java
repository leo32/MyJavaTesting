import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.StreamProgress;
import cn.hutool.core.lang.Console;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.http.HttpUtil;
import org.junit.Test;

import java.math.BigDecimal;

public class httpRequestTest {
    @Test
    public void fetchFile() {
        String[] serverUrl = {"http://52.82.110.192:8888/","http://52.81.47.5:8888/"};
        String[] fileName={"1k.zip","10k.zip","100k.zip","500k.zip","1m.zip","10m.zip"};
        TimeInterval timer = DateUtil.timer();
        for (int i = 0; i < 10; i++) {
            for(int j=0;j<serverUrl.length;j++){
                for(int k=0;k<fileName.length;k++)
                downloadFile(serverUrl[j]+fileName[k],timer,fileName[k],i);
            }
        }

    }

    void downloadFile(String fileUrl,TimeInterval timer,String fileName,int i){
        Long fileSize = HttpUtil.downloadFile(fileUrl, FileUtil.file("./"));
        Long spendTime = timer.interval();
        BigDecimal speed = NumberUtil.div(spendTime, fileSize);
        Console.log("第{}轮测试:文件名：{},文件大小：{},下载时间：{},网速(下载时间/文件大小)：{}",i,fileName, FileUtil.readableFileSize(fileSize), timer.intervalRestart(), speed);
    }
}
