package com.study.cat.home.controller;

import com.study.cat.home.entity.HomeEntity;
import com.study.cat.home.repository.CustomHomeRepository;
import com.study.cat.home.repository.HomeJpaRepository;
import com.study.cat.home.repository.impl.CustomHomeRepositoryImpl;
import com.study.cat.home.service.HomeService;
import com.study.cat.utils.ApiDocumentUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.restdocs.payload.PayloadDocumentation;
import org.springframework.restdocs.request.RequestDocumentation;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;


@AutoConfigureRestDocs
@WebMvcTest(HomeController.class)
@MockBean(JpaMetamodelMappingContext.class)
class HomeControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private HomeService homeService;


    @Test
    @DisplayName("Home Test")
    void test() throws Exception {
        // Given
        Long id = 1L;
        HomeEntity response = HomeEntity.builder().id(id).content("Hello Pig").build();
        given(homeService.findHome(anyLong())).willReturn(response);
        // When
        RequestBuilder result = RestDocumentationRequestBuilders
                .get("/home/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .characterEncoding(StandardCharsets.UTF_8.displayName());
        // Then
        mvc.perform(result)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(
                        MockMvcRestDocumentation.document("test",
                                ApiDocumentUtils.getRequestPreProcessor(),
                                ApiDocumentUtils.getResponsePreProcessor(),
                                RequestDocumentation.pathParameters(
                                        RequestDocumentation.parameterWithName("id").description("Home 식별자")
                                ),
                                PayloadDocumentation.responseFields(
                                        List.of(
                                                PayloadDocumentation.fieldWithPath("id").type(JsonFieldType.NUMBER).description("식별자"),
                                                PayloadDocumentation.fieldWithPath("content").type(JsonFieldType.STRING).description("내용")

                                        )
                                )
                        )
                );
    }

}