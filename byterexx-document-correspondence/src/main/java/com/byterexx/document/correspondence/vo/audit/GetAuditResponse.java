package com.byterexx.document.correspondence.vo.audit;

import com.byterexx.document.correspondence.vo.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class GetAuditResponse extends BaseResponse {

    private List<Audit> audits;
}
