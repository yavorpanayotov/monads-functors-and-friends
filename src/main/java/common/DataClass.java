package common;

import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;

public class DataClass {

    @Override
    public boolean equals(Object other) {
        return reflectionEquals(this, other, false);
    }

    @Override
    public int hashCode() {
        return reflectionHashCode(this, false);
    }
}
