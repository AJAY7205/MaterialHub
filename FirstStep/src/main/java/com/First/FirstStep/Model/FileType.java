package com.First.FirstStep.Model;

public enum FileType {
    PDF,IMAGE,DOC,VIDEO,OTHER,PPT;

    public static FileType fromMimeType(String mimeType) {
        if (mimeType == null) return OTHER;
        if (mimeType.contains("pdf")) return PDF;
        if (mimeType.contains("image")||mimeType.contains("png")) return IMAGE;
        if (mimeType.contains("msword") || mimeType.contains("wordprocessingml")) return DOC;
        if (mimeType.contains("presentation") || mimeType.contains("ppt")) return PPT;
        if (mimeType.contains("video")) return VIDEO;
        return OTHER;
    }

}
