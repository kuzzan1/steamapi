import RootComponent from '../components/root';
import CounterStrikeComponent from '../components/counter-strike/index';
import HomeComponent from '../components/home/index';

export default [
    {
        component: RootComponent,
        childRoutes: [
            {
                path: '/',
                component: HomeComponent
            },
            {
                path: '/cs',
                component: CounterStrikeComponent
            },
            {
                path: '/dota2',
                component: CounterStrikeComponent
            }
        ]
    }
];
