package com.example.data

import android.content.Context
import com.example.domain.model.ExploreModel
import com.example.domain.model.Home1Model
import com.example.domain.model.QuestionsModel
import com.example.domain.repository.QuizRepository

class QuizRepositoryMock(val context : Context):QuizRepository {
    override fun getHome1(): List<Home1Model> {
        
        return listOf(
            Home1Model(context.getString(R.string.art), context.getString(R.string.paiting), R.drawable.img),
            Home1Model(context.getString(R.string.art), context.getString(R.string.sculpture), R.drawable.img_sculpture),


            Home1Model(context.getString(R.string.language), context.getString(R.string.english), R.drawable.img_english),
            Home1Model(context.getString(R.string.language), context.getString(R.string.spanish), R.drawable.img_spain),

            Home1Model(context.getString(R.string.science), context.getString(R.string.sociology), R.drawable.img_sociology),
            Home1Model(context.getString(R.string.science), context.getString(R.string.economics), R.drawable.img_economics),
            Home1Model(context.getString(R.string.science), context.getString(R.string.political_science), R.drawable.img_political_science),

            Home1Model(context.getString(R.string.history), context.getString(R.string.worl_wars), R.drawable.img_worl_war),
            Home1Model(context.getString(R.string.history), context.getString(R.string.ancient_civilizations), R.drawable.img_ancient_civilizations),


            Home1Model(context.getString(R.string.music), context.getString(R.string.classical_music), R.drawable.img_classical_music),
            Home1Model(context.getString(R.string.music), context.getString(R.string.pop_music), R.drawable.img_pop),
            Home1Model(context.getString(R.string.music), context.getString(R.string.hip_hop_music), R.drawable.img_hip_hop),

            )
    }

    override fun getExplore(): List<ExploreModel> {
        return listOf(
            ExploreModel(context.getString(R.string.art)),
            ExploreModel(context.getString(R.string.language)),
            ExploreModel(context.getString(R.string.science)),
            ExploreModel(context.getString(R.string.history)),
            ExploreModel(context.getString(R.string.music)),

        )
    }


    override fun getQuestions(): List<QuestionsModel> {
        return listOf(




            //Hip-Hop Music
            QuestionsModel(
                context.getString(R.string.hip_hop_music),
                context.getString(R.string.hip_hop_questions),
                listOf(context.getString(R.string.hip_hop_answer1), context.getString(R.string.hip_hop_answer2), 
                    context.getString(R.string.hip_hop_answer3), context.getString(R.string.hip_hop_answer4)),
                "2"
            ),
            QuestionsModel(
                context.getString(R.string.hip_hop_music),
                context.getString(R.string.hip_hop_question2),
                listOf(context.getString(R.string.hip_hop_answer5), context.getString(R.string.hip_hop_answer6), 
                    context.getString(R.string.hip_hop_answer7), context.getString(R.string.hip_hop_answer8)),
                "3"
            ),
            QuestionsModel(
                context.getString(R.string.hip_hop_music),
                context.getString(R.string.hip_hop_question3),
                listOf(context.getString(R.string.hip_hop_answer9), context.getString(R.string.hip_hop_answer10),
                    context.getString(R.string.hip_hop_answer11), context.getString(R.string.hip_hop_answer12)),
                "4"
            ),
            QuestionsModel(
                context.getString(R.string.hip_hop_music),
                context.getString(R.string.hip_hop_question4),
                listOf(context.getString(R.string.hip_hop_answer13), context.getString(R.string.hip_hop_answer14), 
                    context.getString(R.string.hip_hop_answer15), context.getString(R.string.hip_hop_answer16)),
                "3"
            ),

            

            //Pop Music
            QuestionsModel(
                context.getString(R.string.pop_music),
                context.getString(R.string.pop_music_question1),
                listOf(context.getString(R.string.pop_music_answer1), 
                    context.getString(R.string.pop_music_answer2), 
                    context.getString(R.string.pop_music_answer3), context.getString(R.string.pop_music_answer4)),
                "2"
            ),
            QuestionsModel(
                context.getString(R.string.pop_music),
                context.getString(R.string.pop_music_question2),
                listOf(context.getString(R.string.pop_music_answer5), context.getString(R.string.pop_music_answer6),
                    context.getString(R.string.pop_music_answer7), context.getString(R.string.pop_music_answer8)),
                "3"
            ),
            QuestionsModel(
                context.getString(R.string.pop_music),
                context.getString(R.string.pop_music_question3),
                listOf(context.getString(R.string.pop_music_answer9), context.getString(R.string.pop_music_answer10), 
                    context.getString(R.string.pop_music_answer11), context.getString(R.string.pop_music_answer12)),
                "1"
            ),
            QuestionsModel(
                context.getString(R.string.pop_music),
                context.getString(R.string.pop_music_question4),
                listOf(context.getString(R.string.pop_music_answer13), context.getString(R.string.pop_music_answer14), 
                    context.getString(R.string.pop_music_answer15), context.getString(R.string.pop_music_answer16)),
                "1"
            ),

            //Classical Music
            QuestionsModel(
                context.getString(R.string.classical_music),
                context.getString(R.string.classic_music_question1),
                listOf(context.getString(R.string.classic_music_answer1), context.getString(R.string.classic_music_answer2),
                    context.getString(R.string.classic_music_answer3), context.getString(R.string.classic_music_answer4)),
                "2"
            ),
            QuestionsModel(
                context.getString(R.string.classical_music),
                context.getString(R.string.classic_music_question2),
                listOf(context.getString(R.string.classic_music_answer5), context.getString(R.string.classic_music_answer6),
                    context.getString(R.string.classic_music_answer7), context.getString(R.string.classic_music_answer8)),
                "1"
            ),
            QuestionsModel(
                context.getString(R.string.classical_music),
                context.getString(R.string.classic_music_question3),
                listOf(context.getString(R.string.classic_music_answer9), context.getString(R.string.classic_music_answer10), 
                    context.getString(R.string.classic_music_answer11), context.getString(R.string.classic_music_answer12)),
                "3"
            ),
            QuestionsModel(
                context.getString(R.string.classical_music),
                context.getString(R.string.classic_music_question4),
                listOf(context.getString(R.string.classic_music_answer13), context.getString(R.string.classic_music_answer14), 
                    context.getString(R.string.classic_music_answer15), context.getString(R.string.classic_music_answer16)),
                "3"
            ),


            //Ancient Civilizations
            QuestionsModel(
                context.getString(R.string.ancient_civilizations),
                context.getString(R.string.ancient_question1),
                listOf(context.getString(R.string.anient_answer1), context.getString(R.string.anient_answer2), 
                    context.getString(R.string.anient_answer3), context.getString(R.string.anient_answer4)),
                "2"
            ),
            QuestionsModel(
                context.getString(R.string.ancient_civilizations),
                context.getString(R.string.ancient_question2),
                listOf(context.getString(R.string.anient_answer5), context.getString(R.string.anient_answer6), 
                    context.getString(R.string.anient_answer7), context.getString(R.string.anient_answer8)),
                "4"
            ),
            QuestionsModel(
                context.getString(R.string.ancient_civilizations),
                context.getString(R.string.ancient_question3),
                listOf(context.getString(R.string.anient_answer9), context.getString(R.string.anient_answer10),
                    context.getString(R.string.anient_answer11), context.getString(R.string.anient_answer12)),
                "2"
            ),
            QuestionsModel(
                context.getString(R.string.ancient_civilizations),
                context.getString(R.string.ancient_question4),
                listOf(context.getString(R.string.anient_answer13), context.getString(R.string.anient_answer14),
                    context.getString(R.string.anient_answer15), context.getString(R.string.anient_answer16)),
                "1"
            ),


            //World Wars
            QuestionsModel(
                context.getString(R.string.worl_wars),
                context.getString(R.string.world_war_question1),
                listOf(context.getString(R.string.world_war_answer1), context.getString(R.string.world_war_answer2), 
                    context.getString(R.string.world_war_answer3), context.getString(R.string.world_war_answer4)),
                "1"
            ),
            QuestionsModel(
                context.getString(R.string.worl_wars),
                context.getString(R.string.world_war_question2),
                listOf("1939-1945", "1914-1918", "1941-1945", "1939-1941"),
                "1"
            ),
            QuestionsModel(
                context.getString(R.string.worl_wars),
                context.getString(R.string.world_war_question3),
                listOf(context.getString(R.string.world_war_answer5), context.getString(R.string.world_war_answer6),
                    context.getString(R.string.world_war_answer7), context.getString(R.string.world_war_answer8)),
                "1"
            ),
            QuestionsModel(
                context.getString(R.string.worl_wars),
                context.getString(R.string.world_war_question4),
                listOf("1990", "1989", "1991", "1992"),
                "1"
            ),



            //Political Science
            QuestionsModel(
                context.getString(R.string.political_science),
                context.getString(R.string.political_science_question1),
                listOf(context.getString(R.string.political_science_answer1), context.getString(R.string.political_science_answer2), 
                    context.getString(R.string.political_science_answer3), context.getString(R.string.political_science_answer4)),
                "3"
            ),
            QuestionsModel(
                context.getString(R.string.political_science),
                context.getString(R.string.political_science_question2),
                listOf(context.getString(R.string.polotocal_science_answer5), context.getString(R.string.polotocal_science_answer6), 
                    context.getString(R.string.polotocal_science_answer7), context.getString(R.string.polotocal_science_answer8)),
                "4"
            ),
            QuestionsModel(
                context.getString(R.string.political_science),
                context.getString(R.string.political_science_question3),
                listOf(context.getString(R.string.polotocal_science_answer9), context.getString(R.string.polotocal_science_answer10),
                    context.getString(R.string.polotocal_science_answer51), context.getString(R.string.polotocal_science_answer12)),
                "1"
            ),
            QuestionsModel(
                context.getString(R.string.political_science),
                context.getString(R.string.political_science_question4),
                listOf(context.getString(R.string.polotocal_science_answer13), context.getString(R.string.polotocal_science_answer14), 
                    context.getString(R.string.polotocal_science_answer15), context.getString(R.string.polotocal_science_answer16)),
                "3"
            ),



            //Economics
            QuestionsModel(
                context.getString(R.string.economics),
                context.getString(R.string.economic_question1),
                listOf(context.getString(R.string.economic_answer1), context.getString(R.string.economic_answer2), 
                    context.getString(R.string.economic_answer3), context.getString(R.string.economic_answer4)),
                "2"
            ),
            QuestionsModel( 
                context.getString(R.string.economics),
                context.getString(R.string.economic_question2),
                listOf(context.getString(R.string.economic_answer5),  context.getString(R.string.economic_answer6), 
                    context.getString(R.string.economic_answer7),  context.getString(R.string.economic_answer8)),
                "3"
            ),
            QuestionsModel(
                context.getString(R.string.economics),
                context.getString(R.string.economic_question3),
                listOf(context.getString(R.string.economic_answer9), context.getString(R.string.economic_answer10), 
                    context.getString(R.string.economic_answer11),  context.getString(R.string.economic_answer12) ),
                "2"
            ), 
            QuestionsModel(
                context.getString(R.string.economics),
                context.getString(R.string.economic_question4),
                listOf(context.getString(R.string.economic_answer13), context.getString(R.string.economic_answer14), 
                    context.getString(R.string.economic_answer15), context.getString(R.string.economic_answer16)), 
                "1" 
            ),


            //Sociology
            QuestionsModel(
                context.getString(R.string.sociology),
                context.getString(R.string.sociology_question1),
                listOf(context.getString(R.string.sociology_answer1), context.getString(R.string.sociology_answer2),
                    context.getString(R.string.sociology_answer3),  context.getString(R.string.sociology_answer4)),
                "2"
            ),
            QuestionsModel(
                context.getString(R.string.sociology),
                context.getString(R.string.sociology_question2), 
                listOf(context.getString(R.string.sociology_answer5), context.getString(R.string.sociology_answer6), 
                    context.getString(R.string.sociology_answer7), context.getString(R.string.sociology_answer8)),  
                "3"
            ),
            QuestionsModel(
                context.getString(R.string.sociology),
                context.getString(R.string.sociology_question3),
                listOf(context.getString(R.string.sociology_answer9), context.getString(R.string.sociology_answer10), 
                    context.getString(R.string.sociology_answer11), context.getString(R.string.sociology_answer12)),   
                "3"
            ),
            QuestionsModel(
                context.getString(R.string.sociology),
                context.getString(R.string.sociology_question4),
                listOf(context.getString(R.string.sociology_answer13), context.getString(R.string.sociology_answer14), 
                    context.getString(R.string.sociology_answer15), context.getString(R.string.sociology_answer16)),   
                "1"
            ),



            // Art Paiting
            QuestionsModel(
                context.getString(R.string.paiting),
            context.getString(R.string.art_paiting_question1),
            listOf(context.getString(R.string.art_paiting_answer1), context.getString(R.string.art_paiting_answer2), 
                context.getString(R.string.art_paiting_answer3), context.getString(R.string.art_paiting_answer4)), 
            "2"
        ),
            QuestionsModel(
                context.getString(R.string.paiting),
                context.getString(R.string.art_paiting_question2), 
                listOf(context.getString(R.string.art_paiting_answer5), context.getString(R.string.art_paiting_answer6), 
                    context.getString(R.string.art_paiting_answer7), context.getString(R.string.art_paiting_answer8)),  
                "1"
            ),
            QuestionsModel(
                context.getString(R.string.paiting),
                context.getString(R.string.art_paiting_question3),
                listOf(context.getString(R.string.art_paiting_answer9), context.getString(R.string.art_paiting_answer10),  
                    context.getString(R.string.art_paiting_answer11), context.getString(R.string.art_paiting_answer12)),  
                "3"
            ),

            QuestionsModel(
                context.getString(R.string.paiting),
                context.getString(R.string.art_paiting_question4),
                listOf(context.getString(R.string.art_paiting_answer13), context.getString(R.string.art_paiting_answer15),  
                    context.getString(R.string.art_paiting_answer14), context.getString(R.string.art_paiting_answer16)),  
                "2"
            ),


                //Art Sculpture

            QuestionsModel(
                context.getString(R.string.sculpture),
                context.getString(R.string.art_sculpture_question1), 
                listOf(context.getString(R.string.art_sculpture_answer1), context.getString(R.string.art_sculpture_answer2), 
                    context.getString(R.string.art_sculpture_answer3), context.getString(R.string.art_sculpture_answer4)), 
                "2" 
            ),
            QuestionsModel(
                context.getString(R.string.sculpture),
                context.getString(R.string.art_sculpture_questio2),
                listOf(context.getString(R.string.art_sculpture_answer5), context.getString(R.string.art_sculpture_answer6), 
                    context.getString(R.string.art_sculpture_answer7), context.getString(R.string.art_sculpture_answer8)),  
                "1"
            ), 
            QuestionsModel(
                context.getString(R.string.sculpture),
                context.getString(R.string.art_sculpture_question3),
                listOf(context.getString(R.string.art_sculpture_answer10), context.getString(R.string.art_sculpture_answer11),  
                    context.getString(R.string.art_sculpture_answer12), context.getString(R.string.art_sculpture_answer13)),  
                "3"
            ),

            QuestionsModel(
                context.getString(R.string.sculpture),
                context.getString(R.string.art_sculpture_question4),
                listOf(context.getString(R.string.art_sculpture_answer14), context.getString(R.string.art_sculpture_answer15), 
                    context.getString(R.string.art_sculpture_answer16), context.getString(R.string.art_sculpture_answer17)),  
                "2"
            ),

                // Language English

            QuestionsModel(
                context.getString(R.string.english),
                // Замените на ссылку или ресурс с изображением для первого вопроса
                context.getString(R.string.english_question1),
                listOf(context.getString(R.string.english_answer1), context.getString(R.string.english_answer12), 
                    context.getString(R.string.english_answer3), context.getString(R.string.english_answer4)),
                "2"
            ),
            QuestionsModel(
                context.getString(R.string.english),
                // Замените на ссылку или ресурс с изображением для второго вопроса
                context.getString(R.string.english_question2),
                listOf(context.getString(R.string.english_answer5), context.getString(R.string.english_answer6),
                    context.getString(R.string.english_answer7), context.getString(R.string.english_answer8)),
                "2"
            ),
            QuestionsModel(
                context.getString(R.string.english),
              // Замените на ссылку или ресурс с изображением для третьего вопроса
                context.getString(R.string.english_question3),
                listOf(context.getString(R.string.english_answer9), context.getString(R.string.english_answer10), 
                    context.getString(R.string.english_answer11), context.getString(R.string.english_answer2)),  
                "3"
            ),
            QuestionsModel(
                context.getString(R.string.english),
               // Замените на ссылку или ресурс с изображением для четвёртого вопроса
                context.getString(R.string.english_question4),
                listOf(context.getString(R.string.english_answer13), context.getString(R.string.english_answer14),
                    context.getString(R.string.english_answer15), context.getString(R.string.english_answer16)),  
                "3"
            ),


            // Language Spanish

            QuestionsModel(
                context.getString(R.string.spanish),
               // Замените на ссылку или ресурс с изображением для первого вопроса
                context.getString(R.string.spain_question1), 
                listOf(context.getString(R.string.spain_answer1), context.getString(R.string.spain_answer2), 
                    context.getString(R.string.spain_answer3), context.getString(R.string.spain_answer4)), 
                "2" 
            ),
            QuestionsModel(
                context.getString(R.string.spanish),
                  // Замените на ссылку или ресурс с изображением для второго вопроса
                context.getString(R.string.spain_question2),
                listOf(context.getString(R.string.spain_answer5), context.getString(R.string.spain_answer6), 
                    context.getString(R.string.spain_answer7), context.getString(R.string.spain_answer8)), 
                "4"
            ),
            QuestionsModel(
                context.getString(R.string.spanish),
            // Замените на ссылку или ресурс с изображением для третьего вопроса
                context.getString(R.string.spain_question3),
                listOf(context.getString(R.string.spain_answer9), context.getString(R.string.spain_answer10),  
                    context.getString(R.string.spain_answer11), context.getString(R.string.spain_answer12)),  
                "1"
            ),
            QuestionsModel(
                context.getString(R.string.spanish),
               // Замените на ссылку или ресурс с изображением для четвёртого вопроса
                context.getString(R.string.spain_question4),
                listOf(context.getString(R.string.spain_answer13), context.getString(R.string.spain_answer14), 
                    context.getString(R.string.spain_answer15), context.getString(R.string.spain_answer16)), 
                "3" 
            )



            )
    }
}