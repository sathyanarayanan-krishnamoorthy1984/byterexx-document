package com.byterexx.document.correspondence.vo.configuration;

import com.byterexx.document.correspondence.vo.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor // 2 usages
@NoArgsConstructor // 1 usage
@Data
public class GetCorrespondenceConfigurationResponse extends BaseResponse {

    private List<CorrespondenceConfiguration> correspondenceConfigurations;
}