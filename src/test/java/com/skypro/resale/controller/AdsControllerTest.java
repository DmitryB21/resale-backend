package com.skypro.resale.controller;

import com.skypro.resale.repository.AdRepository;
import com.skypro.resale.service.impl.AdsServiceImpl;
import com.skypro.resale.service.impl.ImageServiceImpl;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(AdsController.class)
public class AdsControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private AdsServiceImpl adsService;

    @MockBean
    private AdRepository adRepository;
//    @Autowired
//    private ObjectMapper objectMapper;
//    @MockBean
//    private PasswordEncoder encoder;
//    @MockBean
//    private UserRepository userRepository;
//    @MockBean
//    private SomeUserDetailsService userDetailsService;
    @MockBean
    private ImageServiceImpl imageService;
    @InjectMocks
    private AdsController adsController;

//    private final AdsDto adsDto = new AdsDto;
  /*  @Test
    public void testGetAllAdsReturnsCorrectAdsList() throws Exception {
        //подготовка ожидаемого результата

        when(adsService.getAllAds()).thenReturn(Collections.emptyList());
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/ads")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
 */

//                .andExpect(jsonPath("$").exists())
//                .andExpect(jsonPath("$.count").isNumber())
//                .andExpect(jsonPath("$.results").isArray());
    }

//    //подготовка ожидаемого результата
//    when(facultyService.findAllFaculty()).thenReturn(Collections.emptyList());
//    //начало теста
//        mockMvc.perform(MockMvcRequestBuilders
//                .get("/faculty/all")
//                .accept(MediaType.APPLICATION_JSON))
//            .andExpect(status().isOk());


