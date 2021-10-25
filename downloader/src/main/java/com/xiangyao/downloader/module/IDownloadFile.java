package com.xiangyao.downloader.module;

import com.xiangyao.downloader.other.DownloadStatues;

public class IDownloadFile {
    private String fileName;
    private String fileLocalPath;
    private String fileRemotePath;
    private DownloadStatues downloadStatues;
    private long fileSize = 0L;

    public IDownloadFile(IDownloadFileBuilder iDownloadFileBuilder) {
        this.fileName = iDownloadFileBuilder.fileName;
        this.fileLocalPath = iDownloadFileBuilder.fileLocalPath;
        this.fileRemotePath = iDownloadFileBuilder.fileRemotePath;
        this.downloadStatues = iDownloadFileBuilder.downloadStatues;
        this.fileSize = iDownloadFileBuilder.fileSize;
    }

   public static class IDownloadFileBuilder {

        private String fileName;
        private String fileLocalPath;
        private String fileRemotePath;
        private DownloadStatues downloadStatues;
        private long fileSize = 0L;

        public IDownloadFileBuilder fileName(String fileName) {
            this.fileName = fileName;
            return this;
        }

        public IDownloadFileBuilder fileLocalPath(String fileLocalPath) {
            this.fileLocalPath = fileLocalPath;
            return this;
        }

        public IDownloadFileBuilder fileRemotePath(String fileRemotePath) {
            this.fileRemotePath = fileRemotePath;
            return this;
        }

        public IDownloadFileBuilder downloadStatues(DownloadStatues downloadStatues) {
            this.downloadStatues = downloadStatues;
            return this;
        }

        public IDownloadFileBuilder fileSize(long fileSize) {
            this.fileSize = fileSize;
            return this;
        }

        public IDownloadFile build() {
            return new IDownloadFile(this);
        }

    }

    @Override
    public String toString() {
        return "IDownloadFile{" +
                "fileName='" + fileName + '\'' +
                ", fileLocalPath='" + fileLocalPath + '\'' +
                ", fileRemotePath='" + fileRemotePath + '\'' +
                ", downloadStatues=" + downloadStatues +
                ", fileSize=" + fileSize +
                '}';
    }
}
