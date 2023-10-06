package com.example.visprog_week4.data

import com.example.visprog_week4.R
import com.example.visprog_week4.model.LineChat
import com.example.visprog_week4.model.Tokopedia.TokPedCategory
import com.example.visprog_week4.model.Tokopedia.TokPedProducts
import com.example.visprog_week4.model.Instagram.Picture
import com.example.visprog_week4.model.Instagram.Suggestion
import com.example.visprog_week4.model.Instagram.Story
import com.example.visprog_week4.model.Instagram.Feed

class DataSource {

    public fun loadLineChat(): List<LineChat>{
        return listOf<LineChat>(
            LineChat("Lebron James",  "Practice starts in 10, where are you?", "4/10/2023"),
            LineChat("Kobe Bryant", "Hey, how's it going?", "3/10/2023"),
            LineChat("Michael Jordan", "I heard you had a great game last night!", "2/10/2023"),
            LineChat("Stephen Curry",  "Let's grab dinner tonight.", "1/10/2023"),
            LineChat("Kevin Durant", "Can you pass me the ball more often?", "30/9/2023"),
            LineChat("Magic Johnson", "We need to work on our defense.", "30/9/2023"),
            LineChat("Larry Bird",  "I'll be late for practice tomorrow.", "28/9/2023"),
            LineChat("Tim Duncan",  "I'm excited about the upcoming game.", "25/9/2023"),
            LineChat("Shaquille O'Neal",  "I need new sneakers.", "21/9/2023"),
            LineChat("Charles Barkley", "Let's hit the gym early.", "18/9/2023")
        )
    }

    public fun loadTokPedCategoryData(): List<TokPedCategory> {
        return listOf(
            TokPedCategory(R.drawable.skincare, "Skincare", 190),
            TokPedCategory(R.drawable.gadget, "Gadgets", 50),
            TokPedCategory(R.drawable.shoes, "Shoes", 75),
            TokPedCategory(R.drawable.clothing, "Clothing", 200),
            TokPedCategory(R.drawable.furniture, "Furniture", 120),
            TokPedCategory(R.drawable.books, "Books", 300),
            TokPedCategory(R.drawable.sports, "Sports", 80),
            TokPedCategory(R.drawable.makeup, "Makeup", 150),
        )
    }

    public fun loadTokPedProductData(): List<TokPedProducts> {
        return listOf(
            TokPedProducts (
                R.drawable.phone, "PearPhone 12", 8999000, "New York", 40
            ),
            TokPedProducts (
                R.drawable.laptop, "PacBook 2", 13254009, "Los Angeles", 30
            ),
            TokPedProducts (
                R.drawable.smartwatch, "Smartwatch QRS", 19009, "San Francisco", 20
            ),
            TokPedProducts (
                R.drawable.camera, "Canon EOS 718D", 5990000, "Chicago", 10
            )
        )
    }

    public fun loadFeedData(): List<Feed>{
        return listOf<Feed>(
            Feed("john_doe", R.drawable.profile_1, R.drawable.content_1, true, false, 50, "Caption 1. This is a long and detailed caption that spans multiple paragraphs. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ac libero at purus scelerisque ultrices. Integer malesuada a justo eu facilisis. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nam vel nunc nec metus interdum efficitur. Nulla facilisi. Nulla rhoncus est et neque facilisis, vel venenatis quam blandit. Sed viverra justo at mi vestibulum eleifend. Vestibulum ut felis ut tortor tincidunt vehicula at id lacus. Donec feugiat dolor in metus congue, id vestibulum nulla posuere. Fusce a quam purus. Vivamus egestas et nisi in bibendum. Praesent id hendrerit ex. Nullam vel tortor nec neque pharetra congue.", "2023-10-01"),
            Feed("jane_smith", R.drawable.profile_2, R.drawable.content_2, false, true, 10000, "Caption 2. Another long caption to demonstrate multiline text. Duis vehicula, felis id cursus sollicitudin, ipsum arcu interdum libero, vel posuere lectus orci et odio. Sed tristique felis id vehicula laoreet. Suspendisse potenti. Nullam vitae aliquet elit. Etiam in lacinia est. Fusce eget iaculis arcu. Phasellus dictum viverra ex, ac dictum neque pellentesque sit amet. Nullam scelerisque ut velit et sollicitudin. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec vel neque eu leo rhoncus cursus. Sed at sapien ex. Praesent suscipit odio eget libero bibendum, id blandit justo sollicitudin. Cras euismod enim in nulla fringilla, quis dapibus est condimentum. Integer tincidunt nisl nec metus convallis, non bibendum libero elementum.", "2022-06-15"),
            Feed("alex123", R.drawable.profile_3, R.drawable.content_3, true, true, 5000, "Caption 3. A lengthy caption with multiple paragraphs. Vivamus convallis justo odio, et finibus metus laoreet ac. Proin volutpat, quam eget vehicula tincidunt, arcu tortor sollicitudin elit, nec placerat odio libero a libero. Phasellus id odio ac odio tempus lacinia. Donec congue nec nisi in tempor. Vestibulum quis sapien eget libero cursus vehicula. Fusce vestibulum rhoncus mi, id euismod justo laoreet et. Curabitur iaculis, purus in viverra consectetur, elit justo gravida urna, vel congue felis libero non elit. Cras a semper nisl. Aenean tristique tortor a scelerisque. Vivamus eget semper lorem. Duis lacinia libero et sollicitudin. In hac habitasse platea dictumst.", "2020-12-20"),
            Feed("emily_green", R.drawable.profile_4, R.drawable.content_4, false, true, 750, "Caption 4. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ac libero at purus scelerisque ultrices. Integer malesuada a justo eu facilisis. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nam vel nunc nec metus interdum efficitur. Nulla facilisi. Nulla rhoncus est et neque facilisis, vel venenatis quam blandit. Sed viverra justo at mi vestibulum eleifend. Vestibulum ut felis ut tortor tincidunt vehicula at id lacus. Donec feugiat dolor in metus congue, id vestibulum nulla posuere. Fusce a quam purus. Vivamus egestas et nisi in bibendum. Praesent id hendrerit ex. Nullam vel tortor nec neque pharetra congue.", "2018-11-03"),
            Feed("sam_wilson", R.drawable.profile_5, R.drawable.content_5, true, false, 2000, "Caption 5. Another long caption to demonstrate multiline text. Duis vehicula, felis id cursus sollicitudin, ipsum arcu interdum libero, vel posuere lectus orci et odio. Sed tristique felis id vehicula laoreet. Suspendisse potenti. Nullam vitae aliquet elit. Etiam in lacinia est. Fusce eget iaculis arcu. Phasellus dictum viverra ex, ac dictum neque pellentesque sit amet. Nullam scelerisque ut velit et sollicitudin. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec vel neque eu leo rhoncus cursus. Sed at sapien ex. Praesent suscipit odio eget libero bibendum, id blandit justo sollicitudin. Cras euismod enim in nulla fringilla, quis dapibus est condimentum. Integer tincidunt nisl nec metus convallis, non bibendum libero elementum.", "2022-08-22"),
            Feed("lisa_martin", R.drawable.profile_6, R.drawable.content_6, false, false, 3000, "Caption 6. A lengthy caption with multiple paragraphs. Vivamus convallis justo odio, et finibus metus laoreet ac. Proin volutpat, quam eget vehicula tincidunt, arcu tortor sollicitudin elit, nec placerat odio libero a libero. Phasellus id odio ac odio tempus lacinia. Donec congue nec nisi in tempor. Vestibulum quis sapien eget libero cursus vehicula. Fusce vestibulum rhoncus mi, id euismod justo laoreet et. Curabitur iaculis, purus in viverra consectetur, elit justo gravida urna, vel congue felis libero non elit. Cras a semper nisl. Aenean tristique tortor a scelerisque. Vivamus eget semper lorem. Duis lacinia libero et sollicitudin. In hac habitasse platea dictumst.", "2016-02-14"),
            Feed("mike_brown", R.drawable.profile_7, R.drawable.content_7, true, true, 1500, "Caption 7. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ac libero at purus scelerisque ultrices. Integer malesuada a justo eu facilisis. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nam vel nunc nec metus interdum efficitur. Nulla facilisi. Nulla rhoncus est et neque facilisis, vel venenatis quam blandit. Sed viverra justo at mi vestibulum eleifend. Vestibulum ut felis ut tortor tincidunt vehicula at id lacus. Donec feugiat dolor in metus congue, id vestibulum nulla posuere. Fusce a quam purus. Vivamus egestas et nisi in bibendum. Praesent id hendrerit ex. Nullam vel tortor nec neque pharetra congue.", "2005-05-10"),
            Feed("sara_jones", R.drawable.profile_8, R.drawable.content_8, false, false, 8000, "Caption 8. Another long caption to demonstrate multiline text. Duis vehicula, felis id cursus sollicitudin, ipsum arcu interdum libero, vel posuere lectus orci et odio. Sed tristique felis id vehicula laoreet. Suspendisse potenti. Nullam vitae aliquet elit. Etiam in lacinia est. Fusce eget iaculis arcu. Phasellus dictum viverra ex, ac dictum neque pellentesque sit amet. Nullam scelerisque ut velit et sollicitudin. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec vel neque eu leo rhoncus cursus. Sed at sapien ex. Praesent suscipit odio eget libero bibendum, id blandit justo sollicitudin. Cras euismod enim in nulla fringilla, quis dapibus est condimentum. Integer tincidunt nisl nec metus convallis, non bibendum libero elementum.", "2006-09-28"),
            Feed("chris_taylor", R.drawable.profile_9, R.drawable.content_9, true, true, 2500, "Caption 9. A lengthy caption with multiple paragraphs. Vivamus convallis justo odio, et finibus metus laoreet ac. Proin volutpat, quam eget vehicula tincidunt, arcu tortor sollicitudin elit, nec placerat odio libero a libero. Phasellus id odio ac odio tempus lacinia. Donec congue nec nisi in tempor. Vestibulum quis sapien eget libero cursus vehicula. Fusce vestibulum rhoncus mi, id euismod justo laoreet et. Curabitur iaculis, purus in viverra consectetur, elit justo gravida urna, vel congue felis libero non elit. Cras a semper nisl. Aenean tristique tortor a scelerisque. Vivamus eget semper lorem. Duis lacinia libero et sollicitudin. In hac habitasse platea dictumst.", "2001-01-12"),
            Feed("olivia_walker", R.drawable.profile_10, R.drawable.content_10, false, false, 4500, "Caption 10. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ac libero at purus scelerisque ultrices. Integer malesuada a justo eu facilisis. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nam vel nunc nec metus interdum efficitur. Nulla facilisi. Nulla rhoncus est et neque facilisis, vel venenatis quam blandit. Sed viverra justo at mi vestibulum eleifend. Vestibulum ut felis ut tortor tincidunt vehicula at id lacus. Donec feugiat dolor in metus congue, id vestibulum nulla posuere. Fusce a quam purus. Vivamus egestas et nisi in bibendum. Praesent id hendrerit ex. Nullam vel tortor nec neque pharetra congue.", "2017-12-05"),
            Feed("megan_white", R.drawable.profile_11, R.drawable.content_11, true, true, 1800, "Caption 11. Another long caption to demonstrate multiline text. Duis vehicula, felis id cursus sollicitudin, ipsum arcu interdum libero, vel posuere lectus orci et odio. Sed tristique felis id vehicula laoreet. Suspendisse potenti. Nullam vitae aliquet elit. Etiam in lacinia est. Fusce eget iaculis arcu. Phasellus dictum viverra ex, ac dictum neque pellentesque sit amet. Nullam scelerisque ut velit et sollicitudin. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec vel neque eu leo rhoncus cursus. Sed at sapien ex. Praesent suscipit odio eget libero bibendum, id blandit justo sollicitudin. Cras euismod enim in nulla fringilla, quis dapibus est condimentum. Integer tincidunt nisl nec metus convallis, non bibendum libero elementum.", "2013-06-17"),
            Feed("david_anderson", R.drawable.profile_12, R.drawable.content_12, false, true, 6000, "Caption 12. A lengthy caption with multiple paragraphs. Vivamus convallis justo odio, et finibus metus laoreet ac. Proin volutpat, quam eget vehicula tincidunt, arcu tortor sollicitudin elit, nec placerat odio libero a libero. Phasellus id odio ac odio tempus lacinia. Donec congue nec nisi in tempor. Vestibulum quis sapien eget libero cursus vehicula. Fusce vestibulum rhoncus mi, id euismod justo laoreet et. Curabitur iaculis, purus in viverra consectetur, elit justo gravida urna, vel congue felis libero non elit. Cras a semper nisl. Aenean tristique tortor a scelerisque. Vivamus eget semper lorem. Duis lacinia libero et sollicitudin. In hac habitasse platea dictumst.", "2008-03-24"),
            Feed("natalie_clark", R.drawable.profile_13, R.drawable.content_13, true, true, 3500, "Caption 13. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ac libero at purus scelerisque ultrices. Integer malesuada a justo eu facilisis. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nam vel nunc nec metus interdum efficitur. Nulla facilisi. Nulla rhoncus est et neque facilisis, vel venenatis quam blandit. Sed viverra justo at mi vestibulum eleifend. Vestibulum ut felis ut tortor tincidunt vehicula at id lacus. Donec feugiat dolor in metus congue, id vestibulum nulla posuere. Fusce a quam purus. Vivamus egestas et nisi in bibendum. Praesent id hendrerit ex. Nullam vel tortor nec neque pharetra congue.", "2014-10-08"),
            Feed("kevin_harris", R.drawable.profile_14, R.drawable.content_14, false, false, 4200, "Caption 14. Another long caption to demonstrate multiline text. Duis vehicula, felis id cursus sollicitudin, ipsum arcu interdum libero, vel posuere lectus orci et odio. Sed tristique felis id vehicula laoreet. Suspendisse potenti. Nullam vitae aliquet elit. Etiam in lacinia est. Fusce eget iaculis arcu. Phasellus dictum viverra ex, ac dictum neque pellentesque sit amet. Nullam scelerisque ut velit et sollicitudin. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec vel neque eu leo rhoncus cursus. Sed at sapien ex. Praesent suscipit odio eget libero bibendum, id blandit justo sollicitudin. Cras euismod enim in nulla fringilla, quis dapibus est condimentum. Integer tincidunt nisl nec metus convallis, non bibendum libero elementum.", "2022-02-01"),
            Feed("anna_moore", R.drawable.profile_15, R.drawable.content_15, true, false, 300, "Caption 15. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ac libero at purus scelerisque ultrices. Integer malesuada a justo eu facilisis. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nam vel nunc nec metus interdum efficitur. Nulla facilisi. Nulla rhoncus est et neque facilisis, vel venenatis quam blandit. Sed viverra justo at mi vestibulum eleifend. Vestibulum ut felis ut tortor tincidunt vehicula at id lacus. Donec feugiat dolor in metus congue, id vestibulum nulla posuere. Fusce a quam purus. Vivamus egestas et nisi in bibendum. Praesent id hendrerit ex. Nullam vel tortor nec neque pharetra congue.", "2023-09-11"),
            Feed("peter_jackson", R.drawable.profile_16, R.drawable.content_16, false, true, 5600, "Caption 16. A lengthy caption with multiple paragraphs. Vivamus convallis justo odio, et finibus metus laoreet ac. Proin volutpat, quam eget vehicula tincidunt, arcu tortor sollicitudin elit, nec placerat odio libero a libero. Phasellus id odio ac odio tempus lacinia. Donec congue nec nisi in tempor. Vestibulum quis sapien eget libero cursus vehicula. Fusce vestibulum rhoncus mi, id euismod justo laoreet et. Curabitur iaculis, purus in viverra consectetur, elit justo gravida urna, vel congue felis libero non elit. Cras a semper nisl. Aenean tristique tortor a scelerisque. Vivamus eget semper lorem. Duis lacinia libero et sollicitudin. In hac habitasse platea dictumst.", "2023-04-30"),
            Feed("oliver_miller", R.drawable.profile_17, R.drawable.content_17, true, false, 7800, "Caption 17. Another long caption to demonstrate multiline text. Duis vehicula, felis id cursus sollicitudin, ipsum arcu interdum libero, vel posuere lectus orci et odio. Sed tristique felis id vehicula laoreet. Suspendisse potenti. Nullam vitae aliquet elit. Etiam in lacinia est. Fusce eget iaculis arcu. Phasellus dictum viverra ex, ac dictum neque pellentesque sit amet. Nullam scelerisque ut velit et sollicitudin. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec vel neque eu leo rhoncus cursus. Sed at sapien ex. Praesent suscipit odio eget libero bibendum, id blandit justo sollicitudin. Cras euismod enim in nulla fringilla, quis dapibus est condimentum. Integer tincidunt nisl nec metus convallis, non bibendum libero elementum.", "2022-03-12"),
            Feed("mia_davis", R.drawable.profile_18, R.drawable.content_18, false, true, 9200, "Caption 18. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ac libero at purus scelerisque ultrices. Integer malesuada a justo eu facilisis. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nam vel nunc nec metus interdum efficitur. Nulla facilisi. Nulla rhoncus est et neque facilisis, vel venenatis quam blandit. Sed viverra justo at mi vestibulum eleifend. Vestibulum ut felis ut tortor tincidunt vehicula at id lacus. Donec feugiat dolor in metus congue, id vestibulum nulla posuere. Fusce a quam purus. Vivamus egestas et nisi in bibendum. Praesent id hendrerit ex. Nullam vel tortor nec neque pharetra congue.", "2020-11-20")
        )
    }

    public fun loadStoryData(): List<Story>{
        return listOf<Story>(
            Story("john_doe", R.drawable.profile_1, true, false),
            Story("jane_smith", R.drawable.profile_2, false, true),
            Story("alice_johnson", R.drawable.profile_3, true, true),
            Story("david_williams", R.drawable.profile_4, false, false),
            Story("emily_brown", R.drawable.profile_5, true, false),
            Story("michael_davis", R.drawable.profile_6, false, true),
            Story("susan_jackson", R.drawable.profile_7, true, true),
            Story("robert_jones", R.drawable.profile_8, false, false),
            Story("lisa_anderson", R.drawable.profile_9, true, false),
            Story("william_taylor", R.drawable.profile_10, false, true),
            Story("elizabeth_martin", R.drawable.profile_11, true, true),
            Story("james_johnson", R.drawable.profile_12, false, false),
            Story("natalie_rodriguez", R.drawable.profile_13, true, false),
            Story("peter_white", R.drawable.profile_14, false, true),
            Story("olivia_lee", R.drawable.profile_15, true, true),
            Story("thomas_wilson", R.drawable.profile_16, false, false),
            Story("grace_martin", R.drawable.profile_17, true, false),
            Story("jacob_hernandez", R.drawable.profile_18, false, true)
        )
    }

    public fun loadSuggestionData(): List<Suggestion>{
        return listOf<Suggestion>(
            Suggestion("lisa_anderson", R.drawable.profile_9, true, false),
            Suggestion("jane_smith", R.drawable.profile_2, false, true),
            Suggestion("elizabeth_martin", R.drawable.profile_11, true, true),
            Suggestion("olivia_lee", R.drawable.profile_15, true, true),
            Suggestion("david_williams", R.drawable.profile_4, false, false),
            Suggestion("emily_brown", R.drawable.profile_5, true, false),
            Suggestion("susan_jackson", R.drawable.profile_7, true, true),
            Suggestion("grace_martin", R.drawable.profile_17, true, false),
            Suggestion("robert_jones", R.drawable.profile_8, false, false),
            Suggestion("william_taylor", R.drawable.profile_10, false, true),
            Suggestion("natalie_rodriguez", R.drawable.profile_13, true, false),
            Suggestion("john_doe", R.drawable.profile_1, true, false),
            Suggestion("james_johnson", R.drawable.profile_12, false, false),
            Suggestion("alice_johnson", R.drawable.profile_3, true, true),
            Suggestion("peter_white", R.drawable.profile_14, false, true),
            Suggestion("thomas_wilson", R.drawable.profile_16, false, false),
            Suggestion("michael_davis", R.drawable.profile_6, false, true),
            Suggestion("jacob_hernandez", R.drawable.profile_18, false, true)
        )
    }

    public fun loadExplorePageData():List<Picture> {
        return listOf<Picture>(
                Picture("content_1"),
                Picture("content_2"),
                Picture("content_3"),
                Picture("content_4"),
                Picture("content_5"),
                Picture("content_6"),
                Picture("content_7"),
                Picture("content_8"),
                Picture("content_9"),
                Picture("content_10"),
                Picture("content_11"),
                Picture("content_12"),
                Picture("content_13"),
                Picture("content_14"),
                Picture("content_15"),
                Picture("content_16"),
                Picture("content_17"),
                Picture("content_18"),
                Picture("content_19"),
                Picture("content_20"),
                Picture("content_21"),
                Picture("content_22"),
                Picture("content_23"),
                Picture("content_24"),
                Picture("content_25"),
                Picture("content_26"),
                Picture("content_27"),
                Picture("content_28"),
                Picture("content_29"),
                Picture("content_30"),
                Picture("content_31"),
                Picture("content_32"),
                Picture("content_33"),
                Picture("content_34"),
                Picture("content_35"),
                Picture("content_36"),
                Picture("content_37"),
                Picture("content_38"),
                Picture("content_39"),
                Picture("content_40"),
                Picture("content_41"),
                Picture("content_42"),
                Picture("content_43"),
                Picture("content_44"),
                Picture("content_45"),
                Picture("content_46"),
                Picture("content_47"),
                Picture("content_48"),
                Picture("content_49"),
                Picture("content_50"),
                Picture("content_51"),
                Picture("content_52"),
                Picture("content_53"),
                Picture("content_54"),
                Picture("content_55"),
                Picture("content_56"),
                Picture("content_57"),
                Picture("content_58"),
                Picture("content_59"),
                Picture("content_60"),
                Picture("content_61"),
                Picture("content_62"),
                Picture("content_63"),
                Picture("content_64"),
                Picture("content_65"),
                Picture("content_66"),
                Picture("content_67"),
                Picture("content_68"),
                Picture("content_69"),
                Picture("content_70"),
                Picture("content_71"),
                Picture("content_72"),
                Picture("content_73"),
                Picture("content_74"),
                Picture("content_75"),
                Picture("content_76"),
                Picture("content_77"),
                Picture("content_78"),
                Picture("content_79"),
                Picture("content_80")
        )
    }


}