import { useState } from 'react';
import Posts from '../../containers/Posts/Posts';
import PostDetails from '../../components/PostDetails/PostDetails';
import './Dashboard.css';


export default function Dashboard() {

    const [newTitleState, setNewTitleState] = useState("");
    const [selectedState, setSelectedState] = useState(0);

    const [postsState, setPostsState] = useState(
        [
            { id: 111, title: "Happiness", author: "John", content: 'This is the content in the post#111' },
            { id: 112, title: "MIU", author: "Dean", content: 'This is the content in the post#112' },
            { id: 113, title: "Enjoy Life", author: "Jasmine", content: 'This is the content in the post#113' },
        ]
    );

    const setSelected = (id) => {
        setSelectedState(id);
    }

    const onChange = (events) => {
        setNewTitleState(events.target.value);
    }

    const changeFirstPostsTitle = () => {
        let title = newTitleState !== "" ? newTitleState : "Happiness";
        const copyPosts = [...postsState];
        copyPosts[0].title = title;
        setPostsState(copyPosts);
    }

    return (
        <div>
            <div className='form'>
                <h2>Change First Posts' Title</h2>
                <input 
                    type="text" 
                    id="title" 
                    name={newTitleState}
                    onChange={(event) => { onChange(event) }}
                />
                <input 
                    type="button" 
                    value="Change Name"
                    onClick={changeFirstPostsTitle}
                />
            </div>
            <div className='Posts'>
                <Posts 
                    posts={postsState} 
                    setSelected={setSelected}
                />
            </div>
            <div>
                <PostDetails 
                    id={selectedState}
                    post={[...postsState].filter(p => p.id === selectedState)[0]}
                />
            </div>
        </div>
    )

};
