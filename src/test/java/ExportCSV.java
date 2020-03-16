import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.core.text.csv.*;
import cn.hutool.core.text.csv.CsvReader;
import cn.hutool.core.text.csv.CsvUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
public class ExportCSV {

    @Test
    public  void exportFile() {
        CsvReader reader = CsvUtil.getReader();
//从文件中读取CSV数据
        CsvData data = reader.read(FileUtil.file("D:\\My\\北京金控历史净值\\Mapping\\Source\\FundInfo_20200313.csv"));
        List<CsvRow> rows = data.getRows();
//遍历行
        for (CsvRow csvRow : rows) {
            //getRawList返回一个List列表，列表的每一项为CSV中的一个单元格（既逗号分隔部分）
            Console.log(csvRow.getRawList());
        }
    }
}
