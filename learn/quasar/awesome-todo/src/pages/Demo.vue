<template>
<div class="q-pa-md">
    <q-layout view="lHh Lpr lFf" container style="height: 400px" class="my-card">
      <q-header elevated>
        <q-toolbar>
          <q-avatar>
            <q-icon name="timeline"></q-icon>
          </q-avatar>
          <q-toolbar-title>
            <strong>Time</strong> line
          </q-toolbar-title>
        </q-toolbar>
      </q-header>

      <q-page-container>
       <q-timeline :layout="layout" color="secondary">
             <q-timeline-entry heading>
               Timeline heading
               <br>
               ({{$q.screen.lt.sm ? 'Dense' : ($q.screen.lt.md ? 'Comfortable' : 'Loose')}} layout)
             </q-timeline-entry>
       
             <q-timeline-entry
               title="Event Title"
               subtitle="February 22, 1986"
               side="left"
             >
               <div>
                 Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
               </div>
             </q-timeline-entry>
       
             <q-timeline-entry
               title="Event Title"
               subtitle="February 21, 1986"
               side="right"
               icon="delete"
             >
               <div>
                 Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
               </div>
             </q-timeline-entry>
       
             <q-timeline-entry heading>November, 2017</q-timeline-entry>
       
             <q-timeline-entry
               title="Event Title"
               subtitle="February 22, 1986"
               side="left"
             >
               <div>
                 Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
               </div>
             </q-timeline-entry>
       
             <q-timeline-entry
               title="Event Title"
               subtitle="February 22, 1986"
               side="right"
             >
               <div>
                 Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
               </div>
             </q-timeline-entry>
       
             <q-timeline-entry
               title="Event Title"
               subtitle="February 22, 1986"
               side="left"
               color="orange"
               icon="done_all"
             >
               <div>
                 Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
               </div>
             </q-timeline-entry>
       
             <q-timeline-entry
               title="Event Title"
               subtitle="February 22, 1986"
               side="right"
             >
               <div>
                 Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
               </div>
             </q-timeline-entry>
       
             <q-timeline-entry
               title="Event Title"
               subtitle="February 22, 1986"
               side="left"
             >
               <div>
                 Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
               </div>
             </q-timeline-entry>
           </q-timeline>
      </q-page-container>
    </q-layout>
  </div>
</template>

<script>
</script>

<style lang="sass" scoped>
.my-card
  width: 50%
  max-width: 300px
</style>
