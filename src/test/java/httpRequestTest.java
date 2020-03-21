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
        String fileUrl = "https://apicenter.morningstar.com/sample/APIJavaSampleCode.zip";
        TimeInterval timer = DateUtil.timer();
        for (int i = 0; i < 10; i++) {
            Long fileSize = HttpUtil.downloadFile(fileUrl, FileUtil.file("/Users/wenguang/Downloads"));
            Long spendTime = timer.interval();
            BigDecimal speed = NumberUtil.div(spendTime, fileSize);
            Console.log("文件大小：{},下载时间：{},网速：{}", FileUtil.readableFileSize(fileSize), timer.intervalRestart(), speed);
            //Console.log(timer.intervalMinute());//花费分钟数
        }

    }
}
