package commonsolutions.mistakes.apidesign.apiasyncsyncmode;

import lombok.Data;

@Data
public class SyncUploadResponse {
    private String downloadUrl;
    private String thumbnailDownloadUrl;
}
