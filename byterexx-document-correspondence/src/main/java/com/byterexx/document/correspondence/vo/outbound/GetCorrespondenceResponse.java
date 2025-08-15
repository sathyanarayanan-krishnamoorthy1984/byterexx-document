package com.byterexx.document.correspondence.vo.outbound;

import com.byterexx.document.correspondence.vo.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetCorrespondenceResponse extends BaseResponse {
    private List<Correspondence> correspondences;
}
