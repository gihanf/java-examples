import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class OfferDTO {
    public String vendorName;

    public String settlementRate;

    public String financingAmount;

    public OfferDTO(String vendorName, String b, String c) {
        this.vendorName = vendorName;
        this.settlementRate = b;
        this.financingAmount = c;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getSettlementRate() {
        return settlementRate;
    }

    public void setSettlementRate(String settlementRate) {
        this.settlementRate = settlementRate;
    }
    public String getFinancingAmount() {
        return financingAmount;
    }
    public void setFinancingAmount(String financingAmount) {
        this.financingAmount = financingAmount;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }


}
