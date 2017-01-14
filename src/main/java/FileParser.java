import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;

public class FileParser {

    public OfferDTO rowToDTO(String[] line) {
        Stream<String> stream = Arrays.asList(line).stream();

        return new OfferDTO(
                validateVendorName(line),
                validateSettlementRate(line),
                validateFinancingAmount(line)
        );
    }

    private CsvColumn convertToCsvColumn(String columnValue) {
        return new CsvColumn("a","a","a");
    }

    private String validateFinancingAmount(String[] line) {
        String columnValue = line[Columns.FINANCING_AMOUNT.getIndex()];
        validateNotEmpty(columnValue, Columns.FINANCING_AMOUNT.getColumnName());
        return columnValue;
    }

    private String validateSettlementRate(String[] line) {
        String columnValue = line[Columns.SETTLEMENT_RATE.getIndex()];
        validateNotEmpty(columnValue, Columns.SETTLEMENT_RATE.getColumnName());
        return columnValue;
    }

    private String validateVendorName(String[] line) {
        String columnValue = line[Columns.VENDOR_NAME.getIndex()];
        validateNotEmpty(columnValue, Columns.VENDOR_NAME.getColumnName());
        return columnValue;
    }

    private void validateNotEmpty(String columnValue, String columnName) {
        if (StringUtils.isEmpty(columnValue)) {
            throw new IllegalArgumentException(columnName + " can not be blank");
        }
    }

    static class Columns {
        static int index = 0;
        static List<String> columnNames;
        static Column VENDOR_NAME = new Column("vendorName", index);
        static Column SETTLEMENT_RATE = new Column("SettlementRate", index + 1);
        static Column FINANCING_AMOUNT = new Column("FinancingAmount", index + 1);
    }

    private static class Column {
        private String columnName;
        private String value;
        private int index;

        public Column(String name, int index) {
            columnName = name;
            this.index = index;
            Columns.columnNames.add(index, name);
        }

        public String getColumnName() {
            return columnName;
        }

        public int getIndex() {
            return index;
        }

        public String getValue() {
            return value;
        }
    }

    private class CsvColumn {
        private String columnName;
        private String columnValue;
        private String columnIndex;

        public CsvColumn(String columnName, String columnValue, String columnIndex) {
            this.columnName = columnName;
            this.columnValue = columnValue;
            this.columnIndex = columnIndex;
        }
    }

    public static void main(String[] args) {
        String[] csvLine = new String[]{"Retail Express", "10", "12000"};
        FileParser fileParser = new FileParser();
        OfferDTO offerDTO = fileParser.rowToDTO(csvLine);
        System.out.println("offerDTO = " + offerDTO);


    }
}
