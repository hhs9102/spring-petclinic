package org.springframework.samples.petclinic.care.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.Nullable;

import java.util.List;

public class AnimalCareFacilityResponse {

    @JsonProperty("OrganicAnimalProtectionFacilit")
    List<HeadOrRow> headOrRowList;

    public List<HeadOrRow> getHeadOrRowList() {
        return headOrRowList;
    }

    public void setHeadOrRowList(List<HeadOrRow> headOrRowList) {
        this.headOrRowList = headOrRowList;
    }

    public static class HeadOrRow {

        @JsonProperty("head")
        @Nullable
        List<Head> heads;

        @JsonProperty("row")
        @Nullable
        List<Row> row;

        @Nullable
        public List<Head> getHeads() {
            return heads;
        }

        public void setHeads(@Nullable List<Head> heads) {
            this.heads = heads;
        }

        @Nullable
        public List<Row> getRow() {
            return row;
        }

        public void setRow(@Nullable List<Row> row) {
            this.row = row;
        }
    }

    static class Head{
        @JsonProperty("list_total_count")
        @Nullable
        private Integer listTotalCount;
        @JsonProperty("RESULT")
        @Nullable
        private Result result;
        @Nullable
        @JsonProperty("api_version")
        private String apiVersion;

        static class Result {
            @JsonProperty("CODE")
            private String code;
            @JsonProperty("MESSAGE")
            private String message;

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getMessage() {
                return message;
            }

            public void setMessage(String message) {
                this.message = message;
            }
        }

        @Nullable
        public Integer getListTotalCount() {
            return listTotalCount;
        }

        public void setListTotalCount(@Nullable Integer listTotalCount) {
            this.listTotalCount = listTotalCount;
        }

        @Nullable
        public Result getResult() {
            return result;
        }

        public void setResult(@Nullable Result result) {
            this.result = result;
        }

        @Nullable
        public String getApiVersion() {
            return apiVersion;
        }

        public void setApiVersion(@Nullable String apiVersion) {
            this.apiVersion = apiVersion;
        }
    }

    public static class Row{
        @JsonProperty("SUM_YY")
        private String sumYy;
        @JsonProperty("SIGUN_NM")
        private String sigunNm;
        @JsonProperty("ENTRPS_NM")
        private String entrpsNm;
        @JsonProperty("ENTRPS_TELNO")
        private String entrpsTelno;
        @JsonProperty("RM_MATR")
        private String rmMatr;

        public String getSumYy() {
            return sumYy;
        }

        public void setSumYy(String sumYy) {
            this.sumYy = sumYy;
        }

        public String getSigunNm() {
            return sigunNm;
        }

        public void setSigunNm(String sigunNm) {
            this.sigunNm = sigunNm;
        }

        public String getEntrpsNm() {
            return entrpsNm;
        }

        public void setEntrpsNm(String entrpsNm) {
            this.entrpsNm = entrpsNm;
        }

        public String getEntrpsTelno() {
            return entrpsTelno;
        }

        public void setEntrpsTelno(String entrpsTelno) {
            this.entrpsTelno = entrpsTelno;
        }

        public String getRmMatr() {
            return rmMatr;
        }

        public void setRmMatr(String rmMatr) {
            this.rmMatr = rmMatr;
        }
    }


}
