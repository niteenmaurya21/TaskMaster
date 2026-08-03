package org.niteen.tasktracker.dto.attachment;

import jakarta.validation.constraints.Size;


    public class UploadAttachmentRequest {

        //TODO: since it requires Url and filePatch which i cant do now i am just leaving this with the description i will add that in the future

        @Size(max = 500,
                message = "Description cannot exceed 500 characters")
        private String description;

        public UploadAttachmentRequest(String description) {
            this.description = description;
        }

        public UploadAttachmentRequest() {}

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

