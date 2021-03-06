package com.kkulbae.sellup.config;


import lombok.Getter;

/**
 * 에러 코드 관리
 */
@Getter
public enum BaseResponseStatus {
    /**
     * 1000 : 요청 성공
     */
    SUCCESS(true, 1000, "요청에 성공하였습니다."),


    /**
     * 2000 : Request 오류
     */
    // Common
    REQUEST_ERROR(false, 2000, "입력값을 확인해주세요."),
    EMPTY_JWT(false, 2001, "JWT를 입력해주세요."),
    INVALID_JWT(false, 2002, "유효하지 않은 JWT입니다."),
    INVALID_USER_JWT(false,2003,"권한이 없는 유저의 접근입니다."),
    DELETED_USER(false, 2004,"비활성화된 유저입니다."),


    // users
    USERS_EMPTY_USER_ID(false, 2010, "유저 아이디 값을 확인해주세요."),

    // post-users
    POST_USERS_EMPTY_EMAIL(false, 2015, "이메일을 입력해주세요."),
    POST_USERS_INVALID_EMAIL(false, 2016, "이메일 형식을 확인해주세요."),
    POST_USERS_EMPTY_PASSWORD(false, 2017, "패스워드를 입력해주세요."),
    POST_USERS_INVALID_PASSWORD(false, 2018, "패드워드 형식을 확인해주세요."),
    POST_USERS_EMPTY_NICKNAME(false, 2019, "닉네임을 입력해주세요."),
    POST_USERS_INVALID_NICKNAME(false, 2020, "닉네임 형식을 확인해주세요."),


    // post-theme/place
    POST_PLACE_EMPTY_ADDRESS(false, 2021, "주소를 입력해주세요."),
    POST_PLACE_EMPTY_NAME(false, 2022, "이름을 입력해주세요."),
    POST_PLACE_EMPTY_RATING(false, 2023, "평점을 입력해주세요."),
    POST_PLACE_EMPTY_LATITUDE(false, 2024, "위도를 입력해주세요."),
    POST_PLACE_EMPTY_LONGITUDE(false, 2025, "경도를 입력해주세요."),


    // post-celeb
    POST_CELEB_EMPTY_NAME(false, 2026, "이름을 입력해주세요."),
    POST_CELEB_EMPTY_DESCRIPTION(false, 2027, "설명을 입력해주세요."),
    POST_CELEB_EMPTY_JOB(false, 2028, "직업을 입력해주세요."),
    POST_CELEB_EMPTY_PROFILE_IMAGE(false, 2029, "프로필 이미지를 입력해주세요."),

    /**
     * 3000 : Response 오류
     */
    // Common
    RESPONSE_ERROR(false, 3000, "값을 불러오는데 실패하였습니다."),

    // post-users
    DUPLICATED_EMAIL(false, 3013, "중복된 이메일입니다."),
    FAILED_TO_LOGIN(false,3014,"없는 이메일이거나 비밀번호가 틀렸습니다."),
    DUPLICATED_NICKNAME(false,3015,"중복된 닉네임입니다."),


    // post-theme
    INVALID_CELEB(false,3016,"유효하지 않은 셀럽입니다."),


    /**
     * 4000 : Database, Server 오류
     */
    DATABASE_ERROR(false, 4000, "데이터베이스 연결에 실패하였습니다."),
    SERVER_ERROR(false, 4001, "서버와의 연결에 실패하였습니다."),
    THIRD_PARTY_ERROR(false, 4002, "데이터를 불러올 수 없습니다."),

    //[PATCH] /users/{userIdx}
    MODIFY_FAIL_USERNAME(false,4014,"유저네임 수정 실패"),

    PASSWORD_ENCRYPTION_ERROR(false, 4011, "비밀번호 암호화에 실패하였습니다."),
    PASSWORD_DECRYPTION_ERROR(false, 4012, "비밀번호 복호화에 실패하였습니다.");


    // 5000 : 필요시 만들어서 쓰세요
    // 6000 : 필요시 만들어서 쓰세요


    private final boolean isSuccess;
    private final int code;
    private final String message;

    private BaseResponseStatus(boolean isSuccess, int code, String message) {
        this.isSuccess = isSuccess;
        this.code = code;
        this.message = message;
    }
}
