package com.jci.thecatapi.database;

import com.jci.thecatapi.R;
import com.jci.thecatapi.model.Cat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CatDatabase {

    private static List<Cat> _cats;

    public static void SetCats(List<Cat> cats){
        _cats = cats;
    }

    public static List<Cat> GetCats(){
        if (_cats != null) return _cats;

        List<Cat> cats = new ArrayList<>();

        // source: https://www.catbreedslist.com/all-cat-breeds/
        cats.add(new Cat(1,"Ragdoll", "United States", R.drawable.ragdoll, "12-17 years", "Gentle, Quiet, Friendly, Easygoing", "The large, affectionate Ragdoll goes limp with pleasure when you cuddle him in your arms, the trait that led to his name. He’s a big kitty, with males ranging up to 20 pounds, females slightly smaller, starting at 12 pounds and going up to 15 pounds."));
        cats.add(new Cat(2, "Exotic Shorthair", "United States", R.drawable.exotic_shorthair, "12-15 years", "Quiet, Lovely, Warm pure, Sweet", "The Exotic Shorthair is a man-made breed resulting from the cross of Persians with American Shorthairs and other shorthaired cats. The Exotic's body and head-style match that of the Persian, but the breed was separated into its own category in the 1960s. The desired coat is dense, plush and stands away from the body due to the thick undercoat. Because outcrosses are regularly done to Persians, many long-haired kittens occur in Exotic litters. Some associations will register and show these cats as Persians. A bit livelier and more inquisitive than the Persian, Exotics share many of the Persian's gentler personality features."));
        cats.add(new Cat(3, "British Shorthair", "United Kingdom", R.drawable.british_shorthair, "12-17 years", "Affectionate, Easy Going, Gentle, Loyal, Patient, Calm", "The British Shorthair, also called the English Cat or simply the “Brit,” is the national cat of the British Isles. This is a compact, muscular and powerful breed that should be \"cobby\" or chunky in appearance. The British Shorthair has a broad chest, short strong legs and large rounded paws. Its tail is thick at the base, round at the tip and plush but not fluffy. The males are almost always larger than the females; this size difference is more easily recognized in British Shorthairs than in most other domestic breeds. Unlike females, mature males tend to develop prominent chubby cheeks, or jowls, which is another distinguishing gender-based feature."));
        cats.add(new Cat(4, "Persian", "Iran (Persia)", R.drawable.persian, "14-15 years", "Affectionate, Loyal, Sedate, Quiet", "The Persian, also known as the Persian Longhair, is an elegant, graceful, gentle breed whose most distinguishing characteristics are its remarkable coat and its unique head. Today, the Persian is one of the most popular of all feline breeds due to its exceptional beauty, kind temperament and easy-going disposition. While their basic temperaments have changed little over time, their conformation and overall appearance have changed considerably. Modern Persians are medium to large in size and stocky, with short thick legs, massive rumps and distinctively cobby profiles. Their large, round paws are tufted with fur. The Persian’s head is broad in skull, round and unusually large for the size of its body, while its ears are especially tiny in comparison and are tufted, which is called having “ear furnishings.” The Persian’s eyes are big, round and very expressive. Whatever their color, deepness of eye color is preferred in this breed. The Persian’s open, pansy-like face is famously flat, with a perky up-turned nose and an extremely short muzzle that is barely noticeable. Its neck is short and thick, with a distinctive mane-like ruff, and its tail is short and bushy. The heads and facial features of Persians have become increasingly exaggerated over time."));
        cats.add(new Cat(5, "Maine Coon", "United States", R.drawable.maine_coon, "12-15 years", "Adaptable, Intelligent, Loving, Gentle, Independent", "Maine Coons are known for their large size, with females averaging up to 16 pounds and males up to 18, with some tipping the scales at 20-plus pounds. With a long, shaggy coat that lays close to the body, a bushy long tail, tufted paw pads and large ears adorned with furry tufts and \"lynx tips\" on top, their build reflects the Maine Coon's origins in the cold Northeast.\nThe Maine Coon is known in the cat fancy as a \"gentle giant\", much like the Great Dane is known in the dog fancy by that same nickname. This is an extroverted, outgoing, sociable breed, with a loving nature, a kind disposition and a keen intellect. Most Maine Coons are highly trainable and can easily be taught to walk on a harness and leash. They are affectionate, playful animals that typically get along extremely well with children, other cats and even dogs."));
        cats.add(new Cat(6, "American Shorthair", "United States", R.drawable.american_shorthair,"15-17 years", "Active, Curious, Easy Going, Playful, Calm", "The American Shorthair is known for its longevity, robust health, calm disposition, good looks, friendliness and gentleness. It is a true native American breed that comes in a variety of colors, although it does not come in a pointed pattern like that of the Siamese. The best known American Shorthairs are the dramatically marked silver tabbies, which have been popular in commercial advertisements and movies.\nThe American Shorthair ranges in size from medium to large. It is well-built and powerful, with a short, dense coat and large, piercing round eyes. This breed is less square in shape and larger than its counterpart, the British Shorthair. It also has a more oblong rather than a round head, larger ears and longer legs. This is a low-maintenance breed that only requires occasional brushing to keep its coat fresh and manage mild shedding."));
        cats.add(new Cat(7, "Devon Rex", "United Kingdom", R.drawable.devon_rex,"10-15 years", "Highly interactive, Mischievous, Loyal, Social, Playful", "The Devon Rex is a breed of unique appearance. Its large eyes, short muzzle, prominent cheekbones, and huge ears create a characteristic elfin look. Hard and muscular; slender; medium length; broad chest; medium fine boning; body carried high on the legs. Modified wedge; head broad but slightly longer than broad; face full-cheeked with pronounced cheekbones and a whisker break; in profile, nose has strongly marked stop; muzzle short and well developed; prominent whisker break; chin strong and well developed. All colors and patterns including the Himalayan pattern."));
        cats.add(new Cat(8, "Sphynx", "Canada", R.drawable.sphynx,"12-14 years", "Loyal, Inquisitive, Friendly, Quiet, Gentle", "The Sphynx is one of the most unusual and rare of all domestic feline breeds. Its most distinguishing characteristic is that it appears to be entirely hairless. However, most Sphynx do have some degree of short, sparse downy fur that is most noticeable on the ears, muzzle, tail, feet and scrotum. When present, even this fur is barely perceptible to the human eye or to the human touch. The fine fur tends to be more visible on young kittens and then thins or disappears with age. The markings and coloration are highly unique to each Sphynx cat, with color depending entirely upon the pigmentation of its skin. All of the usual domestic cat colors and coat patterns can be found in the Sphynx. The texture of the cat’s skin – which has been said to resemble the fuzz of a peach - feels like soft chamois leather or suede and usually is noticeably warm to the touch. Whiskers and eyebrows may or may not be present, and when present they may be either whole or broken. Kittens are more uniformly wrinkled than are adults, but mature Sphynx should retain some wrinkling, especially around their shoulders and neck."));
        cats.add(new Cat(9, "Scottish Fold", "United Kingdom", R.drawable.scottish_fold,"11-14 years", "Affectionate, Intelligent, Loyal, Playful, Social, Sweet, Loving", "With her uniquely folded ears, round face and wide eyes, the Scottish Fold is described as looking like a pixie, an owl or a teddy bear. A mellow, loving breed, this cat adapts easily to new environments and enjoys adults, children and other pets. The Scottish Fold usually bonds to one person, following you from room to room like a loyal puppy. This playful, intelligent breed has two coat varieties, longhair and shorthair."));
        cats.add(new Cat(10, "Abyssinian", "Egypt", R.drawable.abyssinian,"14-15 years", "Active, Energetic, Independent, Intelligent, Gentle", "The Abyssinian is thought by some to be one of the very oldest of all breeds of domestic cats. Abyssinians resemble the sculptural and painted representations of ancient Egyptian cats – they are medium in size, muscular yet elegant, with long, well-arched necks, large alert ears, long legs and exotic, almond-shaped eyes. They come in a variety of color variations, including lavender, blue, chocolate, black silver, fawn, sorrel, ruddy and sorrel silver. A unique characteristic of the Abyssinian is the banding, or “ticking,” on individual hairs. There typically are three or four bands of color on each hair. The Abyssinian’s coat is soft, silky and lustrous, with a full undercoat. The tail is broad at the base, tapering to a point which is the color of the darkest ticking of the coat."));
        cats.add(new Cat(11, "Oriental", "United States", R.drawable.oriental_shorthair,"12-14 years", "Energetic, Affectionate, Intelligent, Social, Playful, Curious", "The Oriental is a svelte cat with long tapering lines, very lithe but muscular. Long and svelte, a distinctive combination of fine bones and firm muscles; shoulders and hips continue same sleek lines of tubular body. Long tapering wedge; no break at whiskers; skull flat; muzzle fine and wedge-shaped; chin and jaw medium size; nose long and straight, no break. Shorthair: short, fine-textured, glossy or satinlike; lying close to body. Longhair: medium length, fine, silky, without downy undercoat; lying close to body; hair is longest on tail. Orientals come in solid, smoke, shaded, bicolor, particolor, and tabby color classes, making possible over 300 possible colors and patterns."));

        _cats = cats;

        return _cats;
    }

    public static List<Cat> GetFavoriteCats(){
        List<Cat> cats = GetCats().stream().filter(cat -> cat.isFavorite()).collect(Collectors.toList());
        return cats;
    }

    public static Cat GetById(int id){
        return GetCats().stream().filter(cat -> cat.getId() == id).findFirst().orElse(null);
    }

    public static List<Cat> FindByName(String name){
        List<Cat> filteredCats = GetCats().stream()
                .filter(cat -> cat.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
        return filteredCats;
    }

    public static List<Cat> FindFavoritesByName(String name){
        List<Cat> filteredCats = GetFavoriteCats().stream()
                .filter(cat -> cat.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
        return filteredCats;
    }
}
