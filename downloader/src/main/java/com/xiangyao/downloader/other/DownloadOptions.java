package com.xiangyao.downloader.other;


public class DownloadOptions {
    //下载数量
    private int minTaskNum;
    //最大下载数量
    private int maxTaskNum;

    DownloadOptions(IDownloadOptionsBuilder iDownloadOptionsBuilder) {
        this.maxTaskNum = iDownloadOptionsBuilder.maxTaskNum;
        this.minTaskNum = iDownloadOptionsBuilder.minTaskNum;
    }

    protected int getMinTaskNum() {
        return minTaskNum;
    }

    protected int getMaxTaskNum() {
        return maxTaskNum;
    }

    public static class IDownloadOptionsBuilder {
        //下载数量
        private int minTaskNum;
        //最大下载数量
        private int maxTaskNum;

        public IDownloadOptionsBuilder minTakNum(int minTaskNum) {
            this.minTaskNum = minTaskNum;
            return this;
        }

        public IDownloadOptionsBuilder maxTaskNum(int maxTaskNum) {
            this.maxTaskNum = maxTaskNum;
            return this;
        }

        public DownloadOptions build() {
            return new DownloadOptions(this);
        }

    }
}
