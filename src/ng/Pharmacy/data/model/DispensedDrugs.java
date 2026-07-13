package ng.Pharmacy.data.model;

import java.time.LocalDateTime;
import java.util.List;

public class DispensedDrugs {

    private int id;
    private User dispensedBy;
    private List<DispensedDrug> dispensedDrugs;
    private LocalDateTime dispensedDateTime;
}
